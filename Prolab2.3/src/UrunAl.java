
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mert Bilgic
 */
public class UrunAl extends javax.swing.JFrame {
    DefaultTableModel model,model2;
    İslemler islem = new İslemler();
    /**
     * Creates new form UrunAl
     */
    public UrunAl() {
        initComponents();
        model = (DefaultTableModel) p1_tablo.getModel();
        model2 = (DefaultTableModel) u_bilgisi.getModel();
        tablo_doldur();
        tablo_doldur2();
    }

    public void tablo_doldur(){
        model.setRowCount(0);
        
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
                cikti = islem.p1_tablo_getir();
        
        if(cikti!=null){
            
            
            for(p1_tablo veri : cikti){
                
                Object[] eklenecek ={veri.getFirma_id(),veri.getFirma_adi(),veri.getM_id(),veri.getHammade(),veri.getMiktar(),veri.getMaliyet(),veri.getKargo(),veri.getUlke(),veri.getRaf_omru(),veri.getTarih()};
                model.addRow(eklenecek);
            }
        }
        
    }
       public void tablo_doldur2(){
       model2.setRowCount(0);
        
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
                cikti = islem.u_bilgisi_tablo_getir();
                
        if(cikti!=null){
            
            
            for(p1_tablo veri : cikti){
                //System.out.println(veri.getFirma_id()+"  "+veri.getM_id()+"  "+veri.getHammade()+" "+ veri.getMiktar()+"  "+veri.getMaliyet());
                Object[] eklenecek ={veri.getFirma_id(),veri.getM_id(),veri.getHammade(),veri.getMiktar(),veri.getMaliyet(),veri.getTarih()};
                model2.addRow(eklenecek);
            }
        }
       
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        p1_tablo = new javax.swing.JTable();
        kapat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        urun_ismi = new javax.swing.JTextField();
        urun_miktar = new javax.swing.JTextField();
        satin_al = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        kargo_turu_yazısı = new javax.swing.JLabel();
        Guncelle_butonu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        miktar_alani = new javax.swing.JTextField();
        satis_alani = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tarih_alani = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        tarih_kontrol = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarih_gecmis = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        u_bilgisi = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        uyari = new javax.swing.JTextField();

        jLabel3.setText("jLabel3");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Firma_id", "Firma_Adı", "M_id", "Hammade", "Miktar", "Satis", "Uzaklık", "Ülke", "Raf_omru", "U_Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        p1_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1_tabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(p1_tablo);
        if (p1_tablo.getColumnModel().getColumnCount() > 0) {
            p1_tablo.getColumnModel().getColumn(0).setResizable(false);
            p1_tablo.getColumnModel().getColumn(1).setResizable(false);
            p1_tablo.getColumnModel().getColumn(2).setResizable(false);
            p1_tablo.getColumnModel().getColumn(3).setResizable(false);
            p1_tablo.getColumnModel().getColumn(4).setResizable(false);
            p1_tablo.getColumnModel().getColumn(5).setResizable(false);
            p1_tablo.getColumnModel().getColumn(6).setResizable(false);
            p1_tablo.getColumnModel().getColumn(7).setResizable(false);
            p1_tablo.getColumnModel().getColumn(8).setResizable(false);
            p1_tablo.getColumnModel().getColumn(9).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 150));

        kapat.setText("Sekmeyi Kapat");
        kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kapatActionPerformed(evt);
            }
        });
        getContentPane().add(kapat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 330, 120, -1));

        jLabel1.setText("Almak İstediğiniz Ürünü Giriniz:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel2.setText("Ürünün Miktarını Giriniz:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        getContentPane().add(urun_ismi, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 187, 250, -1));
        getContentPane().add(urun_miktar, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 216, 290, -1));

        satin_al.setText("Satın Al");
        satin_al.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satin_alActionPerformed(evt);
            }
        });
        getContentPane().add(satin_al, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 119, 49));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 292, 592, -1));
        getContentPane().add(kargo_turu_yazısı, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 241, 348, -1));

        Guncelle_butonu.setText("Güncelle");
        Guncelle_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guncelle_butonuActionPerformed(evt);
            }
        });
        getContentPane().add(Guncelle_butonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 119, 43));

        jLabel9.setText("Miktar:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel10.setText("Satis:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));
        getContentPane().add(miktar_alani, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 144, -1));

        satis_alani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satis_alaniActionPerformed(evt);
            }
        });
        getContentPane().add(satis_alani, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 165, -1));

        jLabel5.setText("Tarih:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, 20));
        getContentPane().add(tarih_alani, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 142, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1340, 20));

        tarih_kontrol.setText("Tarih Kontrol");
        tarih_kontrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarih_kontrolActionPerformed(evt);
            }
        });
        getContentPane().add(tarih_kontrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, 120, 40));

        tarih_gecmis.setColumns(20);
        tarih_gecmis.setRows(5);
        jScrollPane2.setViewportView(tarih_gecmis);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 350, 80));

        jLabel6.setText("S.K.T");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 40, 30));

        jLabel8.setText("Geçmiş Ürünler:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 100, -1));

        u_bilgisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "firma_id", "m_id", "hammade", "stok_durumu", "alıs_fiyatı", "SKT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(u_bilgisi);
        if (u_bilgisi.getColumnModel().getColumnCount() > 0) {
            u_bilgisi.getColumnModel().getColumn(0).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(1).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(2).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(3).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(4).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 560, 150));

        jLabel11.setText("Uyari Metini:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 80, -1));
        getContentPane().add(uyari, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kapatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_kapatActionPerformed

    private void satin_alActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satin_alActionPerformed
        İslemler.genel_toplam=0;
        İslemler.toplam_alım=0;
        String urun = urun_ismi.getText();
        int miktar = Integer.parseInt(urun_miktar.getText());
        miktar=islem.p1_urun_al(urun, miktar);
        uyari.setText("");
       if(miktar==9999){
           uyari.setText("İstediğiniz ürününü elindire bulunduran bir tedarikçi yok");
       }
        while(miktar!=0&&miktar!=9999){
            miktar=Math.abs(miktar);
            miktar=islem.p1_urun_al(urun, miktar);
        }
        
        tablo_doldur();
        tablo_doldur2();
        
        
       
        
       
        
    }//GEN-LAST:event_satin_alActionPerformed
       int selectedrow;
    private void p1_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1_tabloMouseClicked
        
        selectedrow = p1_tablo.getSelectedRow();
        
        miktar_alani.setText(model.getValueAt(selectedrow,4).toString());
        satis_alani.setText(model.getValueAt(selectedrow,5).toString());
        tarih_alani.setText(model.getValueAt(selectedrow,9).toString());
        
 
           
    }//GEN-LAST:event_p1_tabloMouseClicked

    private void Guncelle_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guncelle_butonuActionPerformed
        
        int miktar = Integer.valueOf(miktar_alani.getText());
        int satis = Integer.valueOf(satis_alani.getText());
        int f_id = (int)model.getValueAt(selectedrow, 0);
        int m_id = (int)model.getValueAt(selectedrow, 2);
        
        String tarih = tarih_alani.getText();
        
        islem.secili_satırı_guncelle(f_id,m_id,miktar,satis,tarih);
        
        
        tablo_doldur();
        
        miktar_alani.setText(model.getValueAt(selectedrow,4).toString());
        satis_alani.setText(model.getValueAt(selectedrow,5).toString());
        tarih_alani.setText(model.getValueAt(selectedrow,9).toString());
    }//GEN-LAST:event_Guncelle_butonuActionPerformed

    private void satis_alaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satis_alaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satis_alaniActionPerformed

    private void tarih_kontrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarih_kontrolActionPerformed
        String t_g =islem.tarih_kontrol();
        //alanı temizliyoruz.
        tarih_gecmis.setText("");
        //tarihi gecmis ürünleri basıyoruz
        tarih_gecmis.setText("Kaldrılan Ürünler:\n\n"+t_g);
        
        tablo_doldur();
        tablo_doldur2();
    }//GEN-LAST:event_tarih_kontrolActionPerformed

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
            java.util.logging.Logger.getLogger(UrunAl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunAl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunAl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunAl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrunAl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guncelle_butonu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton kapat;
    private javax.swing.JLabel kargo_turu_yazısı;
    private javax.swing.JTextField miktar_alani;
    private javax.swing.JTable p1_tablo;
    private javax.swing.JButton satin_al;
    private javax.swing.JTextField satis_alani;
    private javax.swing.JTextField tarih_alani;
    private javax.swing.JTextArea tarih_gecmis;
    private javax.swing.JButton tarih_kontrol;
    private javax.swing.JTable u_bilgisi;
    private javax.swing.JTextField urun_ismi;
    private javax.swing.JTextField urun_miktar;
    private javax.swing.JTextField uyari;
    // End of variables declaration//GEN-END:variables
}
