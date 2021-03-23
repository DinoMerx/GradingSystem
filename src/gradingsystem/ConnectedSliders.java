package gradingsystem;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConnectedSliders
{
    public void createAndShowGUI()
    {
        JSlider s0 = new JSlider(0, 100, 25);
        JSlider s1 = new JSlider(0, 100, 25);
        JSlider s2 = new JSlider(0, 100, 25);
        JSlider s3 = new JSlider(0,100, 25);

        SliderGroup sliderGroup = new SliderGroup();
        sliderGroup.add(s0);
        sliderGroup.add(s1);
        sliderGroup.add(s2);
        sliderGroup.add(s3);

        JPanel panel =new JPanel(new GridLayout(0,2));
        panel.add(s0);
        panel.add(createListeningLabel(s0));
        panel.add(s1);
        panel.add(createListeningLabel(s1));
        panel.add(s2);
        panel.add(createListeningLabel(s2));
        panel.add(s3);
        panel.add(createListeningLabel(s3));
        panel.add(createListeningLabel(s0, s1, s2,s3));

        JFrame f = new JFrame();
        f.getContentPane().add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static JLabel createListeningLabel(final JSlider ... sliders)
    {
        final JLabel label = new JLabel("");
        for (JSlider slider : sliders)
        {
            slider.addChangeListener(new ChangeListener()
            {
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    int sum = 0;
                    for (JSlider slider : sliders)
                    {
                        sum += slider.getValue();
                    }
                    label.setText("Sum: "+sum);
                }
            });
        }
        return label;
    }

    private static JLabel createListeningLabel(final JSlider slider)
    {
        final JLabel label = new JLabel("");
        slider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                label.setText(String.valueOf(slider.getValue()));
            }
        });
        return label;
    }


}


class SliderGroup
{
    private final Map<JSlider, Integer> values;
    private final LinkedList<JSlider> candidates;

    private final ChangeListener changeListener;
    private boolean updating = false;

    SliderGroup()
    {
        this.values = new HashMap<JSlider, Integer>();
        this.candidates = new LinkedList<JSlider>();

        changeListener = new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                JSlider source = (JSlider)e.getSource();
                update(source);
            }
        };
    }

    private void update(JSlider source)
    {
        if (updating)
        {
            return;
        }
        updating = true;

        int delta = source.getValue() - values.get(source);
        if (delta > 0)
        {
            distributeRemove(delta, source);
        }
        else
        {
            distributeAdd(delta, source);
        }


        for (JSlider slider : candidates)
        {
            values.put(slider, slider.getValue());
        }

        updating = false;
    }


    private void distributeRemove(int delta, JSlider source)
    {
        int counter = 0;
        int remaining = delta;
        while (remaining > 0)
        {
            JSlider slider = candidates.removeFirst();
            counter++;

            if (slider == source)
            {
                candidates.addLast(slider);
            }
            else
            {
                if (slider.getValue() > 0)
                {
                    slider.setValue(slider.getValue()-1);
                    remaining--;
                    counter = 0;
                }
                candidates.addLast(slider);
                if (remaining == 0)
                {
                    break;
                }
            }
            if (counter > candidates.size())
            {
                String message = "Can not distribute "+delta+" among "+candidates;
                //System.out.println(message);
                //return;
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void distributeAdd(int delta, JSlider source)
    {
        int counter = 0;
        int remaining = -delta;
        while (remaining > 0)
        {
            JSlider slider = candidates.removeLast();
            counter++;

            if (slider == source)
            {
                candidates.addFirst(slider);
            }
            else
            {
                if (slider.getValue() < slider.getMaximum())
                {
                    slider.setValue(slider.getValue()+1);
                    remaining--;
                    counter = 0;
                }
                candidates.addFirst(slider);
                if (remaining == 0)
                {
                    break;
                }
            }
            if (counter > candidates.size())
            {
                String message = "Can not distribute "+delta+" among "+candidates;
                //System.out.println(message);
                //return;
                throw new IllegalArgumentException(message);
            }
        }
    }


    void add(JSlider slider)
    {
        candidates.add(slider);
        values.put(slider, slider.getValue());
        slider.addChangeListener(changeListener);
    }

    void remove(JSlider slider)
    {
        candidates.remove(slider);
        values.remove(slider);
        slider.removeChangeListener(changeListener);
    }

}