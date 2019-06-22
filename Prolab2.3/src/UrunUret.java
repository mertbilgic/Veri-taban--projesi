

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
public class UrunUret extends javax.swing.JFrame {
    DefaultTableModel model,model2;
    İslemler islem = new İslemler();
    final int yetersiz_ürün_kodu=9999;
    /**
     * Creates new form UrunUret
     */
    public UrunUret() {
        initComponents();
         model = (DefaultTableModel) u_bilgisi.getModel();
         model2 = (DefaultTableModel) kimyasal.getModel();
        tablo_doldur();
        tablo_doldur2();
        
    }

   public void tablo_doldur(){
       model.setRowCount(0);
        
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
                cikti = islem.u_bilgisi_tablo_getir();
                
        if(cikti!=null){
            
            
            for(p1_tablo veri : cikti){
                
                Object[] eklenecek ={veri.getFirma_id(),veri.getM_id(),veri.getHammade(),veri.getMiktar(),veri.getMaliyet()};
                model.addRow(eklenecek);
            }
        } 
   }
      public void tablo_doldur2(){
       model2.setRowCount(0);
          
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
                cikti = islem.kimyasal_tablo_getir();
                
        if(cikti!=null){
            
            
            for(p1_tablo veri : cikti){
                
                Object[] eklenecek ={veri.getUrun_id(),veri.getUrun_adi(),veri.getBilesen(),veri.getMiktar(),veri.getTarih(),veri.getRaf_omru(),veri.getI_maliyeti(),veri.getMaliyet(),veri.getSatis()};
                model2.addRow(eklenecek);
            }
        }
       
       
   }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        u_bilgisi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kimyasal = new javax.swing.JTable();
        kapat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        urun_adi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kar_oranı = new javax.swing.JTextField();
        uret = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        u_sayi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        uyari_yazisi = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        u_bilgisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "firma_id", "m_id", "hammade", "stok_durumu", "alıs_fiyatı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(u_bilgisi);
        if (u_bilgisi.getColumnModel().getColumnCount() > 0) {
            u_bilgisi.getColumnModel().getColumn(0).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(1).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(2).setResizable(false);
            u_bilgisi.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Firma Hammade Bilgisi:");

        jLabel2.setText("Kimyasal Ürün Bilgisi:");

        kimyasal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün_id", "Ürün_adı", "Bileşenleri", "Stok", "Üretim_Tarihi", "Raf_Ömrü", "İşçilik M.", "Toplam M.", "Satis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(kimyasal);
        if (kimyasal.getColumnModel().getColumnCount() > 0) {
            kimyasal.getColumnModel().getColumn(0).setResizable(false);
            kimyasal.getColumnModel().getColumn(1).setResizable(false);
            kimyasal.getColumnModel().getColumn(2).setResizable(false);
            kimyasal.getColumnModel().getColumn(4).setResizable(false);
            kimyasal.getColumnModel().getColumn(5).setResizable(false);
            kimyasal.getColumnModel().getColumn(6).setResizable(false);
            kimyasal.getColumnModel().getColumn(7).setResizable(false);
            kimyasal.getColumnModel().getColumn(8).setResizable(false);
        }

        kapat.setText("Sekmeyi Kapat");
        kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kapatActionPerformed(evt);
            }
        });

        jLabel3.setText("Ürün Adı:(H2/O)");

        jLabel4.setText("Kar Oranı:");

        uret.setText("Üret");
        uret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uretActionPerformed(evt);
            }
        });

        jLabel5.setText("İstenilen Adet:");

        jLabel6.setText("Uyari Metini:");

        uyari_yazisi.setColumns(20);
        uyari_yazisi.setRows(5);
        jScrollPane3.setViewportView(uyari_yazisi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kar_oranı))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(u_sayi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(urun_adi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(604, 604, 604)
                        .addComponent(kapat))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uret, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(kapat))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(urun_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(u_sayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kar_oranı, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uret, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    boolean sayi_mi(char girilen){
        
        int giris =girilen;
        boolean sonuc=false;
        if(giris>64 && giris<91 || giris>96 && giris<123){
             sonuc = true;
        }
        return sonuc;
    }
    private void kapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kapatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_kapatActionPerformed

    private void uretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uretActionPerformed
        //Uyari yazısını temizliyoruz
        uyari_yazisi.setText("");
        İslemler.uyari="";
        int kar =Integer.valueOf(kar_oranı.getText());
        
        islem.genel_toplam=0;
        
        String text=urun_adi.getText();
        String bilesen="";
        String urun_adi="";
        String sayi="0";
        String[] bil = new String[10];
        int[] adet = new int[10];
        int k=0,t=0;
        for(int i=0;i<text.length();i++){
            
            if(k==0&&text.charAt(i)!='/'){
                bilesen+=text.charAt(i);
                bil[t]="";
                bil[t]+=text.charAt(i);
            }
            else if(text.charAt(i)!='/'){
                
               boolean sonuc =sayi_mi(text.charAt(i));
                if(sonuc)
                 bil[t]+=text.charAt(i);   
                else
                sayi+=text.charAt(i); 
            }
            if(text.charAt(i)!='/'){
                
                urun_adi+=text.charAt(i);
                k++;
            }
            else{
                
                k=0;
                bilesen+="-";
                adet[t]=Integer.valueOf(sayi);
                t++;
                sayi="0";
            }
        }
        adet[t]=Integer.valueOf(sayi);
        int i_miktar=Integer.valueOf(u_sayi.getText());
        t++;
        //System.out.println("  Bilesen: "+bilesen+"    urun_adi:  "+urun_adi+"   sayi:"+sayi+" adet1:"+adet[0]+"    adet2:"+adet[1]+" bil 1:  "+bil[0]+" bil 2:"+bil[1]+"istenen miktar"+i_miktar  );
        int hata_kodu= islem.stokta_var_mı(bil, adet, t, i_miktar);
        if(hata_kodu!=yetersiz_ürün_kodu){
        islem.firma_urun_al(bil, adet, t, i_miktar);
        islem.kimyasal_var_mı(urun_adi,bilesen,bil,adet,t,i_miktar,kar);
        }
        else{
            uyari_yazisi.setText("Yetersiz Stok!!!!!!!!!\n"+İslemler.uyari);
        }
        
        tablo_doldur();
        tablo_doldur2();
        //tablo_doldur2();
    }//GEN-LAST:event_uretActionPerformed

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
            java.util.logging.Logger.getLogger(UrunUret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunUret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunUret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunUret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrunUret().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton kapat;
    private javax.swing.JTextField kar_oranı;
    private javax.swing.JTable kimyasal;
    private javax.swing.JTable u_bilgisi;
    private javax.swing.JTextField u_sayi;
    private javax.swing.JButton uret;
    private javax.swing.JTextField urun_adi;
    private javax.swing.JTextArea uyari_yazisi;
    // End of variables declaration//GEN-END:variables
}
