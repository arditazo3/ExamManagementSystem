package al.edu.fti.utils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RenderComboBox {

    public static JComboBox<Concept> getRendererComboBox(JComboBox<Concept> comboBox, List<Concept> listConcepts) {

        Concept[] conceptsArray = new Concept[listConcepts.size()];
        conceptsArray = listConcepts.toArray(conceptsArray);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(conceptsArray));

        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(final JList<?> list,
                                                          final Object value,
                                                          final int index,
                                                          final boolean isSelected,
                                                          final boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                if (value instanceof Concept)
                    setText(((Concept) value).getLabel());

                return this;
            }
        });

        return comboBox;
    }

}
