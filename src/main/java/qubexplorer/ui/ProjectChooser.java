package qubexplorer.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import qubexplorer.SonarQubeProjectConfiguration;
import qubexplorer.server.SonarQube;
import qubexplorer.ui.task.Task;
import qubexplorer.ui.task.TaskExecutionException;
import qubexplorer.ui.task.TaskExecutor;

/**
 *
 * @author Victor
 */
public class ProjectChooser extends javax.swing.JDialog {

    public enum Option {

        ACCEPT,
        CANCEL
    }

    private Option option;

    /**
     * Creates new form ProyectChooser
     */
    public ProjectChooser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        resourceCombox.setRenderer(new ProjectRenderer());
        url.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                validateDialog();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                validateDialog();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                validateDialog();
            }

        });
        AutoCompleteDecorator.decorate(resourceCombox, new ObjectToStringConverter() {
            
            @Override
            public String getPreferredStringForItem(Object item) {
                String represantion="";
                if(item != null) {
                    SonarQubeProjectConfiguration project=(SonarQubeProjectConfiguration) item;
                    represantion=ProjectRenderer.toString(project);
                }
                return represantion;
            }
            
        });
    }

    public void setServerUrlEnabled(boolean b) {
        url.setEnabled(b);
    }

    public Option showDialog() {
        validateDialog();
        setLocationRelativeTo(getParent());
        setVisible(true);
        return option;
    }

    public void setSelectedUrl(String selectedUrl) {
        url.setText(selectedUrl);
    }

    public String getSelectedUrl() {
        return url.getText();
    }
    
    public SonarQubeProjectConfiguration getSelectedProject() {
        return resourceCombox.getSelectedItem() == null ? null : ((SonarQubeProjectConfiguration)resourceCombox.getSelectedItem());
    }

    public void validateDialog() {
        boolean valid = resourceCombox.getSelectedItem() != null && url.getText() != null;
        okButton.setEnabled(valid);
    }

    public void loadProjectKeys() {
        TaskExecutor.execute(new ProjectsTask(new SonarQube(getSelectedUrl()), new ProjectContext(null)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        resourceCombox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.jLabel2.text")); // NOI18N

        url.setText(org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.url.text")); // NOI18N

        resourceCombox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                resourceComboxItemStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(loadButton, org.openide.util.NbBundle.getMessage(ProjectChooser.class, "ProjectChooser.loadButton.text")); // NOI18N
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resourceCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(url, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loadButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(resourceCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        option = Option.ACCEPT;
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        option = Option.CANCEL;
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        option = Option.CANCEL;
    }//GEN-LAST:event_formWindowClosing

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        loadProjectKeys();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void resourceComboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_resourceComboxItemStateChanged
        validateDialog();
    }//GEN-LAST:event_resourceComboxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox resourceCombox;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables

    public class ProjectsTask extends Task<List<SonarQubeProjectConfiguration>> {

        private final SonarQube sonarQube;

        public ProjectsTask(SonarQube sonarQube, ProjectContext projectContext) {
            super(projectContext, sonarQube.getServerUrl());
            this.sonarQube = sonarQube;
            loadButton.setEnabled(false);
        }

        @Override
        public List<SonarQubeProjectConfiguration> execute() throws TaskExecutionException {
            return sonarQube.getProjects(getUserCredentials());
        }

        @Override
        protected void success(List<SonarQubeProjectConfiguration> result) {
            resourceCombox.removeAllItems();
            Collections.sort(result, new Comparator<SonarQubeProjectConfiguration>() {

                @Override
                public int compare(SonarQubeProjectConfiguration t, SonarQubeProjectConfiguration t1) {
                    return t.getName().compareToIgnoreCase(t1.getName());
                }
                
            });
            DefaultComboBoxModel model = (DefaultComboBoxModel) resourceCombox.getModel();
            for (SonarQubeProjectConfiguration sonarProject : result) {
                model.addElement(sonarProject);
            }
        }

        @Override
        protected void destroy() {
            loadButton.setEnabled(true);
        }
        
    }

}
