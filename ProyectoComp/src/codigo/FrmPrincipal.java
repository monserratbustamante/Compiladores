/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {
 private ArrayList<String> datosAnalizados; 
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        datosAnalizados = new ArrayList<>(); // Inicialización del ArrayList
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = " LINEA  "  +  cont  +  " \t\tSIMBOLO\n ";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += " LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Comillas: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Cadena:
                    resultado += "  <Cadena>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Cadena: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Tipo_dato: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Reservada_if: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Reservada_else: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Reservada_Do: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Reservada_while: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case For:
                    resultado += "  <Reservada for>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Reservada_for: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_igual: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_suma: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                    case Gato:
                    resultado += "  <Gato>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Gato" + ": " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_resta: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_multi: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_division: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_logico: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_incremento: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_relacional: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_atribucion: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Op_boolean: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Parentesis: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Parentesis_cierre: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("llave_abrir: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("llave_cierre: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("corch_abrir: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("corch_cierre: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("main: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("punto_coma: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Identificador: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    datosAnalizados.add("Numero: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    datosAnalizados.add("no definido: " + lexer.lexeme); // Agregar al ArrayList
                  
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnalizarLex)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(386, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnalizarLex)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 50, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
