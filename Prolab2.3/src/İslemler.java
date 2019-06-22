import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class İslemler {
      
    private Connection con =null;
    
    private Statement statement =null;
    
    private Statement statement2 =null;
     
    private PreparedStatement preparedstatement=null;
    
    final int yetersiz_ürün_kodu=9999 ;
    
    static String uyari="",uyari2="",uyari3="";
    
    static int genel_toplam=0,toplam_alım=0;
    
    public İslemler(){
        
        //?useUnicode=true&characterEncoding=utf8" türkçe karater ile ilgili problem yaşamamızı engelliyor
        //"jdbc:mysql://localhost:3306/calisan";
        String url="jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.d_ismi+"?useUnicode=true&characterEncoding=utf8";
            
        try {
            //driver ımızı özellikle başlatıyoruz bunu yapmazsak bazen sıkıntı çıkabiliyor
            //Bunu yaptığımızda jdbc driver ını ekstradan çağırmış oluyoruz
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("jdbc driver'ı bulunamadi");
        }
        try {
            con=DriverManager.getConnection(url,Database.kullanici_adi,Database.sifre);
           //System.out.println("Veritabi baglantisi basarili");
            
        } catch (SQLException ex) {
            System.out.println("Veritabani baglantisi basarisiz");
        }
    } 
    
    public ArrayList<p1_tablo> p1_tablo_getir(){
        
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        String sorgu ="SELECT T1.firma_id,T1.firma_adi,T3.hammadde,T2.miktar,t2.satıs,t1.uzaklık,t1.ulke,t3.m_id,t2.uretim_tarihi,t3.raf_omru FROM t_firma_bilgisi T1, t_ana_tablo T2, t_madde_bilgisi T3 WHERE T1.firma_id=T2.firma_id AND T2.m_id=T3.m_id";
        
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id= rs.getInt("firma_id");
                String ad= rs.getString("firma_adi");
                String hammadde=rs.getString("hammadde");
                int miktar = rs.getInt("miktar");
                int maliyet = rs.getInt("satis");
                int uzaklık = rs.getInt("uzaklık");
                int m_id= rs.getInt("m_id");
                String ulke= rs.getString("ulke");
                String uretim_tarihi=rs.getString("uretim_tarihi");
                int raf_omru=rs.getInt("raf_omru");
                
                cikti.add(new p1_tablo(id, ad, hammadde, miktar,maliyet,uzaklık,ulke,m_id,raf_omru,uretim_tarihi));
            }
            
            return cikti;
        } catch (SQLException ex) {
            System.out.println(ex);
            
            return null;
        }
    }
    public ArrayList<p1_tablo> musteri_tablo_getir(){
        
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        String sorgu ="SELECT * FROM `musteri` WHERE 1";
        
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                
                int musteri_id=rs.getInt("musteri_id");
                String musteri_adi=rs.getString("musteri_adi");
                String adres=rs.getString("Adres");
                int y_bilgi=rs.getInt("y_id");
                
                
                cikti.add(new p1_tablo(musteri_id,musteri_adi,adres,y_bilgi));
            }  
            return cikti;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    public ArrayList<p1_tablo> u_bilgisi_tablo_getir(){
        
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
        String sorgu="SELECT t1.firma_id ,t1.m_id,t2.hammadde, t1.stok_durumu,t1.alıs_fiyatı,t1.SKT FROM `u_anatablo`t1,t_madde_bilgisi t2 WHERE t1.m_id=t2.m_id";
        
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id= rs.getInt("firma_id");
                int m_id= rs.getInt("m_id");
                String hammadde=rs.getString("hammadde");
                int miktar = rs.getInt("stok_durumu");
                int maliyet = rs.getInt("alıs_fiyatı");
                String skt=rs.getString("SKT");
                //System.out.println("stok:  "+miktar+"  maliyet:  "+maliyet);
                cikti.add(new p1_tablo(id, m_id, hammadde, miktar,maliyet,skt));
            }           
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return cikti;
    }
    public ArrayList<p1_tablo> kimyasal_tablo_getir(){
         
         ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
         
         String sorgu="SELECT t2.urun_ıd,t2.uretim_tarihi,t2.is_maliyeti,t2.top_maliyet,t2.satıs_fiyatı,t1.urun_adı,t1.bilesenleri,t1.Stok,t1.raf_omru FROM urun_bilgisi t1,urun_bilgisi_detay t2 WHERE t1.urun_ıd=t2.urun_ıd";
         
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                
                int urun_id= rs.getInt("urun_ıd");
                
                String urun_adı=rs.getString("urun_adı");
                String bilesen=rs.getString("bilesenleri");
                String uretim=rs.getString("uretim_tarihi");
                
                int raf_o=rs.getInt("raf_omru");
                int is_maliyet=rs.getInt("is_maliyeti");
                int top_maliyet=rs.getInt("top_maliyet");
                int satis_fiyati=rs.getInt("satıs_fiyati");  
                int stok=rs.getInt("Stok");
                
                cikti.add(new p1_tablo(urun_id, urun_adı, bilesen,stok,uretim, raf_o, is_maliyet, top_maliyet , satis_fiyati));       
            }
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return cikti;
     }
    public ArrayList<p1_tablo> urun_bilgisi_getir(){
        String sorgu = "SELECT * FROM `urun_bilgisi` WHERE 1";
         ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
         
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                
                int urun_id=rs.getInt("urun_ıd");
                String urun_adi=rs.getString("urun_adı");
                String bilesenleri=rs.getString("bilesenleri");
                int stok=rs.getInt("Stok");
                int raf_omru=rs.getInt("raf_omru");
                 
                cikti.add(new p1_tablo(urun_id,urun_adi,bilesenleri,stok,raf_omru));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);    
        }    
        return cikti;
    }
    public ArrayList<p1_tablo> m_urun_bilgisi_getir(){
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
        String sorgu="SELECT * FROM `m_urun_bilgisi` WHERE 1";
        
        try {
            statement=con.createStatement();
            
            ResultSet rs= statement.executeQuery(sorgu);
            
            while(rs.next()){
                int musteri_id=rs.getInt("musteri_id");
                int urun_id=rs.getInt("urun_id");
                
                String urun_adi=rs.getString("urun_adi");
                
                int maliyet=rs.getInt("alıs_fiyati");
                int stok=rs.getInt("stok");
                
                cikti.add(new p1_tablo(musteri_id, urun_id, urun_adi, maliyet, stok));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cikti;
    }
    public ArrayList<p1_tablo> firma_bilgisi_tablo(){
        
         ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
         String sorgu="SELECT * FROM `t_firma_bilgisi` WHERE 1";
        
        try {
            statement=con.createStatement();
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                
                int firma_id=rs.getInt("firma_id");
                String firma_adi=rs.getString("firma_adi");
                String sehir=rs.getString("sehir");
                String ulke=rs.getString("ulke");
                int uzaklik=rs.getInt("uzaklık");
                       
             cikti.add(new p1_tablo(firma_id,firma_adi, sehir, ulke,uzaklik));   
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public ArrayList<p1_tablo> musteri_bilgisi_getir(){
        String sehir="",ulke="";
        int uzaklik=0;
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        
        String sorgu="SELECT * FROM `musteri` WHERE 1";
        String sorgu2;//="SELECT * FROM `yol_bilgi` WHERE y_id = ?";
        
        try {
            statement= con.createStatement();
            statement2= con.createStatement();
            ResultSet rs= statement.executeQuery(sorgu);
            
            
            while(rs.next()){
                
                int musteri_id=rs.getInt("musteri_id");
                String musteri_ad=rs.getString("musteri_adi");
                String adres=rs.getString("Adres");
                int y_id=rs.getInt("y_id");
                //System.out.println("---------------------------------------------------->"+y_id);
                sorgu2="SELECT * FROM `yol_bilgi` WHERE y_id ="+y_id;
                
                ResultSet rs2 =statement2.executeQuery(sorgu2);
                
                while(rs2.next()){
                    
                    sehir=rs2.getString("sehir");
                    ulke=rs2.getString("ulke");
                    uzaklik=rs2.getInt("uzaklık");
                }
                
                cikti.add(new p1_tablo(musteri_id, musteri_ad, adres, sehir, ulke, uzaklik));
    
            } 
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return cikti;
    }
    public ArrayList<p1_tablo> yol_bilgisi_tablo(){
        
         ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
         String sorgu="SELECT * FROM `yol_bilgi` WHERE 1";
        
        try {
            statement=con.createStatement();
            
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                
                int y_id=rs.getInt("y_id");
                String sehir=rs.getString("sehir");
                String ulke=rs.getString("ulke");
                int uzaklik=rs.getInt("uzaklık");
                
                
             cikti.add(new p1_tablo(y_id,uzaklik,sehir, ulke));   
            }
            
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public ArrayList<p1_tablo> urun_kar(){
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        String sorgu="SELECT urun_ıd,urun_adı,bilesenleri,kar FROM `urun_bilgisi` WHERE 1";
        
        try {
            statement=con.createStatement();
            
             ResultSet rs= statement.executeQuery(sorgu);
        
            while(rs.next()){
                
                int urun_ıd=rs.getInt("urun_ıd");
                String urun_adı=rs.getString("urun_adı");
                String bilesenleri=rs.getString("bilesenleri");
                int kar =rs.getInt("kar");
                System.out.println(urun_adı+"  "+kar);
                
                cikti.add(new p1_tablo(urun_ıd, urun_adı, kar, bilesenleri));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cikti;
    }
    public ArrayList<p1_tablo> musteri_kar(){
        ArrayList<p1_tablo> cikti = new ArrayList<p1_tablo>();
        String sorgu="SELECT * FROM `musteri_kar` WHERE 1";
        
        try {
            statement=con.createStatement();
            
             ResultSet rs= statement.executeQuery(sorgu);
        
            while(rs.next()){
                
                int musteri_id=rs.getInt("musteri_id");
                int urun_ıd=rs.getInt("urun_ıd");
                int kar =rs.getInt("kar");
                
                cikti.add(new p1_tablo(musteri_id,urun_ıd,kar));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cikti;
    }
    //Tedarikçinin tablosunu güncelliyor
    public void tablo_guncelle(int f_id,int m_id,int miktar){
        
        String sorgu="UPDATE `t_ana_tablo` SET miktar=? WHERE m_id=? AND firma_id=?";
        try {
            preparedstatement = con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, miktar);
            preparedstatement.setInt(2, m_id);
            preparedstatement.setInt(3, f_id);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public void u_tablo_gun(int m_id,int stok ,int maliyet,String skt){
        String sorgu="INSERT INTO u_anatablo (firma_id, m_id,stok_durumu,alıs_fiyatı,SKT) VALUES (100,?,?,?,?)";
        System.out.println("u_anatablo---------->Stok:  "+stok);
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, m_id);
            preparedstatement.setInt(2, stok);
            preparedstatement.setInt(3, maliyet);
            preparedstatement.setString(4,skt);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void secili_satırı_guncelle(int f_id,int m_id,int y_miktar,int y_satis,String y_tarih){
        
        String sorgu="UPDATE `t_ana_tablo` SET miktar=?,satıs=?,uretim_tarihi=? WHERE firma_id=? AND m_id=?";
        
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, y_miktar);
            preparedstatement.setInt(2, y_satis);
            preparedstatement.setString(3,y_tarih);
            preparedstatement.setInt(4, f_id);
            preparedstatement.setInt(5, m_id);
           
            preparedstatement.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void tarih_gecmis2(int f_id,int m_id,String tarih){
        String sorgu="Delete FROM u_anatablo WHERE firma_id=? AND m_id=? AND SKT=?";
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, f_id);
            preparedstatement.setInt(2, m_id);
            preparedstatement.setString(3,tarih);
            
            preparedstatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tarih_gecmis(int f_id,int m_id,String tarih){
        String sorgu="Delete FROM t_ana_tablo WHERE firma_id=? AND m_id=? AND uretim_tarihi=?";
       // System.out.println("SİLME İSLEMİNE GİRDİ");
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, f_id);
            preparedstatement.setInt(2, m_id);
            preparedstatement.setString(3,tarih);
            
            preparedstatement.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }
    public int  p1_urun_al(String madde,int miktar){
      System.out.println("MADDE:  "+madde+"  MİKTAR:   "+miktar);
        String tarih2="bos";
        int stokYok=9999;
        int m_id=0,f_id=0,uzaklık,maliyet;
        int t_miktar=0,temp;
        double birim=1,toplam2=Integer.MAX_VALUE,toplam=Integer.MAX_VALUE;
        String t_ulke;
        String tarih="";
        String sorgu1="SELECT m_id FROM t_madde_bilgisi WHERE hammadde= ?";
        //String sorgu2="SELECT *FROM t_ana_tablo WHERE m_id=?";
        //SELECT t1.firma_id,t2.satıs,t1.uzaklık,t2.miktar,t1.ulke,t2.uretim_tarihi,t3.raf_omru FROM t_firma_bilgisi t1 ,t_ana_tablo t2,t_madde_bilgisi t3,yol_bilgi  WHERE t2.m_id=2 AND t1.firma_id=t2.firma_id AND y_id= t1.firma_id and t2.m_id=t3.m_id
        String sorgu2="SELECT t1.firma_id,t2.satıs,t1.uzaklık,t2.miktar,t1.ulke,t2.uretim_tarihi,t3.raf_omru FROM t_firma_bilgisi t1 ,t_ana_tablo t2,t_madde_bilgisi t3 WHERE t2.m_id=? AND t1.firma_id=t2.firma_id AND t2.m_id=t3.m_id";
        
        try {
            preparedstatement = con.prepareStatement(sorgu1);
          
            preparedstatement.setString(1,madde);
           ResultSet rs = preparedstatement.executeQuery();
           while(rs.next()){m_id=rs.getInt("m_id");}
           
           preparedstatement =con.prepareStatement(sorgu2);
           preparedstatement.setInt(1,m_id);
           rs = preparedstatement.executeQuery();
       
           while(rs.next()){
               
               maliyet=rs.getInt("satıs");
               uzaklık=rs.getInt("uzaklık");
               t_ulke=rs.getString("ulke");
               temp=rs.getInt("miktar");
               tarih= rs.getString("uretim_tarihi");
               int raf= rs.getInt("raf_omru");
                if(t_ulke.equals("Türkiye"))
                       birim=0.5;
                   else
                       birim=1;
               if(temp==0) continue; 
               double sonuc =((maliyet*temp)+(uzaklık*birim))/temp;
               System.out.println("sonuc:--->"+sonuc);
               if(sonuc<toplam2){
                  
                   
                   if(temp==0) continue;
                   t_miktar=rs.getInt("miktar");
                   f_id=rs.getInt("firma_id");
                   //System.out.println("miktar"+miktar);
                   int y_t=(Integer.valueOf(tarih)+raf);
                   //System.out.println("----->y_t:   "+y_t);
                    tarih2= String.valueOf(y_t);
                    //System.out.println("--->>>>>tarih:   "+tarih2);
                    
                   toplam=((maliyet*miktar)+(uzaklık*birim));
                   toplam2=sonuc;
                  //System.out.println("Firma iD:"+f_id+"maliyet:"+toplam+"t_____Miktar:"+t_miktar+"               miktar"+miktar);   
               }  
           }
           if(t_miktar==0){
               //System.out.println("STOK YOK");
               return stokYok;
           }
          // System.out.println("Firma iD:"+f_id+"maliyet:"+toplam+"t_____Miktar:"+t_miktar+"               miktar"+miktar);
           t_miktar-=miktar;
           //Ürün alım işlemi bitti
           if(t_miktar==0||t_miktar>0){
               System.out.println("------------------->miktar"+miktar);
               toplam_alım+=miktar;
               genel_toplam+=toplam;
               //System.out.println("----->>>>>>>MİKTAR"+t_miktar+"  f_id"+f_id+" m_id"+m_id);
              //tablo_guncelle(f_id, m_id,t_miktar); 
              //System.out.println("---->tarih: "+tarih2);
               System.out.println("u_tablo_gun------------->>>"+toplam_alım);
              u_tablo_gun(m_id, toplam_alım,genel_toplam,tarih2);
              tablo_guncelle(f_id, m_id,t_miktar); 
              return 0;
           }
           else if(t_miktar<0){
               
            //System.out.println("Firma iD:"+f_id+"maliyet:"+toplam+"Miktar:"+t_miktar);
               genel_toplam+=toplam;
               System.out.println("------------------->t_miktar+miktar"+(t_miktar+miktar));
               toplam_alım+=(t_miktar+miktar);
               miktar=Math.abs(t_miktar);
               toplam=Integer.MAX_VALUE;
              // System.out.println("Güncellemeye giden veriler:");
             //  System.out.println("-------------------------------->  f_id"+f_id+"m_id "+m_id);

               tablo_guncelle(f_id, m_id,0); 
               //System.out.println("-----------------------------------------------------------------------------");
               //System.out.println("\n\nMadde:-----"+madde+"Miktar:-----"+miktar+"t___miktar"+t_miktar);       
           }
        } catch (SQLException ex) {
           // System.out.println("Problem 1----->Ürün alımında sıkıntı var\n\n"+ex);
        }
        return t_miktar;
    }
    public String tarih_kontrol(){
       String veri="";
       String sorgu="SELECT firma_id,t1.m_id,uretim_tarihi,raf_omru FROM t_ana_tablo t1 ,t_madde_bilgisi t2 WHERE t1.m_id=t2.m_id";
       String sorgu2="SELECT * FROM `u_anatablo` WHERE 1";
       Date now = new Date();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");

      /// System.out.println(now.getDate());
        try {
            
           statement=con.createStatement();
          
           ResultSet rs2=statement.executeQuery(sorgu2);
            
          while(rs2.next()){
            int f_id= rs2.getInt("firma_id");
            int m_id=rs2.getInt("m_id");
            String tarih= rs2.getString("SKT");
            
            Date date = simpleDateFormat.parse(tarih);
              //System.out.println(tarih+"\n");
            if(date.getTime()<now.getTime()){
                tarih_gecmis2(f_id, m_id, tarih);
            }
            
          }
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
            String tarih= rs.getString("uretim_tarihi");
            int f_id= rs.getInt("firma_id");
            int m_id=rs.getInt("m_id");
            int raf= rs.getInt("raf_omru");
            
            int y_t=Integer.valueOf(tarih)+raf;
            
            tarih= String.valueOf(y_t);
            
             Date date = simpleDateFormat.parse(tarih);
             
             if(date.getTime()<now.getTime()){
                 veri+="firma_id: "+f_id+" m_id: "+m_id+"  tarih: "+(y_t-raf);
                 veri+="\n";
                 tarih=String.valueOf((y_t-raf));
                 tarih_gecmis(f_id, m_id, tarih);      
             }
            }
        } 
         catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParseException ex) {
               Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return veri;
    }
    //Stok varsa kimysal var mı diye bakıyor
    //Eğer varsa yeni ve normal şekilde üretiyor
    public void kimyasal_var_mı(String urun_adi,String bilesen,String[] bilesen2,int[] adet,int sayac,int i_miktar,int kar){
        
        String sorgu="SELECT * FROM `urun_bilgisi` WHERE urun_adı LIKE '"+urun_adi+"'";
        int sonuc=0,urun_id=0;
        
        //Kullanıcıdan tarih almamak için obje oluşturarak bilgisayardan tarihi çekiyoruz.
        SimpleDateFormat bicim=new SimpleDateFormat("ddMMyyyy");
        Date tarih=new Date();
        String tarih2=bicim.format(tarih);
        tarih2=tarih2.trim();
        //System.out.println("tarih:  "+tarih2);
       
        try {   
            statement=con.createStatement();
            
            ResultSet rs=statement.executeQuery(sorgu);
            //System.out.println("Kimyasal:  "+kimyasal);
            //Sorgunun boş olup olmadığını kontrol ediyoruz.
            while(rs.next()){
                urun_id=rs.getInt("urun_ıd");
                sonuc++;
            }
            if(sonuc==0){
                //yeni ürün üretilecek
                uyari+="Ürün Yok\n";
                uyari3+="Yeni Kimyasal\n";
               // System.out.println("Ürün yok");
                int raf_omru=yeni_kimysal_raf(bilesen2,sayac);
                yeni_kimyasal_uret(urun_adi,urun_id,bilesen,tarih2,i_miktar,kar,raf_omru);
            }
            else{
                //mevcut ürün
                uyari+="Ürün Var\n";
                uyari3+="Kayıtli kimyasal\n";
               //System.out.println("Ürün var");
               // System.out.println("kimyasal_uret"+miktar);
                kimyasal_uret(urun_id,tarih2,i_miktar,kar);
            }
        } catch (SQLException ex) {
            System.out.println("Kimyasal kontorlü yapılırken hata çıktı\n\n"+ex);
        }
    }
    public int kimysal_stok_var_mi(String urun_adi,int miktar){
        
        String sorgu="SELECT SUM(Stok) FROM urun_bilgisi WHERE urun_adı LIKE ? ";
        int stok=9999;
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            //preparedstatement.setString(1,"Stok");
            preparedstatement.setString(1,urun_adi);
            
            ResultSet rs=preparedstatement.executeQuery();
            
            while(rs.next())
                stok=rs.getInt(1);
                
           
            //System.out.println("Stok:  "+stok);
            if(stok!=99999&&stok<miktar){
                uyari3=urun_adi+" adlı üründen yeterli stokt yok\nTedarikçiden üretim için kimyasal alınıyor...\n";
                return 9999;
            }
            else{
                uyari3=urun_adi+" adlı ürün stokta var\n";
                return stok;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stok;
    }
    //Oluşturduğumuz kimyasal ürün için gerekli bileşenler elimizde varsa ürünü almak için kullanıyoruz.Eğer elimizde ürün yoksa ekrana uyari mesajı basıcaz
    public int stokta_var_mı(String[] bilesen2,int[] adet,int t,int i_miktar){
       
        int t_stok=0,stok=0;
        int ihtiyac;
        //System.out.println("sayac:  "+t);
        for(int i=0;i<t;i++){
            //System.out.println("------->>>>>"+bilesen2[i]);
        }
        //System.out.println("------->>>>>>i_miktar:   "+i_miktar);
        for(int i=0;i<t;i++){
            if(adet[i]==0) adet[i]=1;
            ihtiyac=adet[i]*i_miktar;
            t_stok=0;
        
        String sorgu ="SELECT t2.hammadde,t1.stok_durumu,t1.alıs_fiyatı FROM u_anatablo t1,t_madde_bilgisi t2 WHERE  t2.m_id=t1.m_id AND t2.hammadde LIKE '"+bilesen2[i]+"'";
       
            try {
                preparedstatement=con.prepareStatement(sorgu);
                
                ResultSet rs= preparedstatement.executeQuery();
                while(rs.next()){
                    
                    stok= rs.getInt("stok_durumu");
                    //System.out.println("STOKKKAKAKAKAK :  "+stok);
                    //System.out.println(bilesen2[i]+"  "+stok);
                    String hammade=rs.getString("hammadde");
                    
                   // int alis_fiyati=rs.getInt("alıs_fiyatı");
                    t_stok+=stok;              
                }
                //System.out.println("ihtiyac: "+ihtiyac+"  t_stok:"+t_stok);
                if(ihtiyac>t_stok){
                    uyari+="Yeterli "+bilesen2[i]+" yok\n";
                    uyari3+="Yeterli "+bilesen2[i]+" yok\n";
                   // System.out.println("Yeterli "+bilesen2[i]+" yok");
                    return yetersiz_ürün_kodu;
                }
                else{
                    uyari+="Yeterli "+bilesen2[i]+" var\n";
                    uyari3+="Yeterli "+bilesen2[i]+" var\n";
                    //System.out.println("Yeterli "+bilesen2[i]+" var");
                }         
            } catch (SQLException ex) {
                Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        return 1;
    }
    public void firma_stok_guncelle(int id,int miktar,double fiyat){
        String sorgu="UPDATE u_anatablo SET stok_durumu=?,alıs_fiyatı=alıs_fiyatı-? WHERE id=?;";
        System.out.println("firma_stok_guncelle---->:"+miktar);
        try {
            preparedstatement=con.prepareStatement(sorgu);
            preparedstatement.setInt(1, miktar);
            preparedstatement.setDouble(2, fiyat);
            preparedstatement.setInt(3, id);
            
            preparedstatement.executeUpdate();
               
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void firma_urun_al(String[] bilesen2,int[] adet,int t,int i_miktar){
        System.out.println("GenelToplam:   "+genel_toplam+"    toplam_alım"+toplam_alım);
        System.out.println("/////////////////////////////////////////////////////////////////////////  i_miktar:        "+i_miktar);
        uyari3+="Tedarikçiden ürün alınıyor\n";
        int k=0,id=0;
        int miktar=0;
        int toplam=0;
        int t_miktar=0,temp;
                
        //System.out.println("sayac:  "+t);
        for(int i=0;i<t;i++){
            //Her ürünün ilk turunda buraya girmesini sağla eğer değer alındıysa buraya uğramasın
            //Daha sonra sayacı geri sararak bu çözüm üret
           if(k==0){
                if(adet[i]==0) adet[i]=1;
                 miktar=adet[i]*i_miktar;
                 System.out.println(bilesen2[i]+" için gerekli miktar: "+miktar);
           }
 
           //Boş stokların gelmesini engelle şuan eksik var
           //HATA ÇIKARSA %% DELERİ GERİ KOY!!!!!!!
        String sorgu ="SELECT t1.id,t2.hammadde,t1.stok_durumu,t1.alıs_fiyatı FROM u_anatablo t1,t_madde_bilgisi t2 WHERE  t2.m_id=t1.m_id AND t1.stok_durumu>0 AND t2.hammadde LIKE '"+bilesen2[i]+"'";
            
            try {
                preparedstatement=con.prepareStatement(sorgu);
       
                ResultSet rs= preparedstatement.executeQuery();
                while(rs.next()){
                    
                    String hammade=rs.getString("hammadde");
                    t_miktar=rs.getInt("stok_durumu");
                    System.out.println("------------------------------------------------"+t_miktar);
                    id = rs.getInt("id");
                    toplam=rs.getInt("alıs_fiyatı");
                    System.out.println("Alıs Fiyat:"+toplam+"  stok DURURUMUU"+t_miktar);
                    double birim_fiyat=(1.0*toplam/(t_miktar*1.0))*i_miktar+1;
                //System.out.println("1.------->  t_miktar:  "+t_miktar+"  miktar:  "+miktar);
                int kopya=t_miktar;
                    t_miktar-=miktar;
                System.out.println("-------//////////////////////>  t_miktar:  "+t_miktar+"  miktar:  "+miktar); 
           if(t_miktar==0||t_miktar>0){
               toplam_alım+=miktar;
               genel_toplam+=birim_fiyat;
               //k=0;
              firma_stok_guncelle(id,t_miktar,birim_fiyat);
              break;
           }
           else if(t_miktar<0&&t_miktar!=-miktar){
               genel_toplam+=birim_fiyat;
               toplam_alım+=(kopya);
               miktar=Math.abs(t_miktar);
               System.out.println("Ddeğişim sonrası----->"+miktar);
               //k++;
               //i--;
               firma_stok_guncelle(id,0,birim_fiyat);
           }
                }
            } catch (SQLException ex) {
                Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
            } 
       }
    }
    //Gelen kimysal ürünler arasında ömrü en kısa olanı raf ömrü yapmak için kullanıcaz
    public int yeni_kimysal_raf(String[] bilesen,int sayac){
        int omur=Integer.MAX_VALUE;
        int raf=0;
            for(int i=0;i<sayac;i++){
                String sorgu="SELECT raf_omru FROM `t_madde_bilgisi` WHERE hammadde LIKE ' "+ bilesen[i]+ " '";
                try {
                    statement=con.createStatement();
                    statement.executeQuery(sorgu);
                    ResultSet rs=statement.executeQuery(sorgu);
                    
                               
                    while(rs.next()){
                        raf=rs.getInt("raf_omru");
                        if(raf<omur){
                            omur=raf;
                        }
                    } 
                }
                catch (SQLException ex) {
                    Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
        return omur;
    }
    public void yeni_kimyasal_uret(String urun_adi,int urun_id,String bilesen,String tarih,int miktar,int kar,int raf_omru){
        String sorgu="INSERT INTO `urun_bilgisi` (`urun_ıd`, `urun_adı`, `bilesenleri`, `Stok`, `raf_omru`,kar) VALUES (NULL, ?, ?, ?, ?,0);";
        String sorgu2="SELECT urun_ıd FROM `urun_bilgisi` WHERE urun_adı LIKE ' "+urun_adi+" '";
        String sorgu3="INSERT INTO `urun_bilgisi_detay` (`urun_ıd`,`Stok`,`uretim_tarihi`, `is_maliyeti`, `top_maliyet`, `satıs_fiyatı`) VALUES (?, ?, ?, ?, ?);";
        
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, urun_adi);
            preparedstatement.setString(2, bilesen);
            preparedstatement.setString(3, bilesen);
            preparedstatement.setInt(4, kar);
            preparedstatement.setInt(5,raf_omru);
            
            preparedstatement.executeUpdate();
            
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu2);
            
            while(rs.next())
                urun_id=rs.getInt(urun_id);
            
          
            preparedstatement=con.prepareStatement(sorgu3);
            
            preparedstatement.setInt(1,urun_id);
            preparedstatement.setString(2, tarih);
            preparedstatement.setInt(3, miktar);
            preparedstatement.setInt(4, (genel_toplam+miktar));
            double sonuc=genel_toplam*(kar/100.0);
            //System.out.println("Genel_toplam"+genel_toplam+"KAR:   "+kar+"sonuc ürün:"+ sonuc);
            preparedstatement.setDouble(5, (genel_toplam+sonuc));
             
            preparedstatement.executeUpdate();    
        } 
        catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    //önce sorgula yoksa ınset varsa update
    public void kimyasal_uret(int urun_id,String tarih, int miktar,int kar){
        
        String sorgu1="SELECT urun_ıd FROM `urun_bilgisi_detay` WHERE urun_ıd=?";
        String sorgu2="INSERT INTO `urun_bilgisi_detay` (`Sıra`, `urun_ıd`, `Stok`, `uretim_tarihi`, `is_maliyeti`, `top_maliyet`, `satıs_fiyatı`) VALUES (NULL,?,?,?,?,?,?);";
        String sorgu3="UPDATE urun_bilgisi_detay SET is_maliyeti=is_maliyeti+?,top_maliyet=top_maliyet+?,satıs_fiyatı=satıs_fiyatı+? WHERE urun_ıd=?";
        String sorgu4="UPDATE urun_bilgisi SET Stok=stok+? WHERE urun_ıd=?";
        
        int durum=0;
        try {
            preparedstatement=con.prepareStatement(sorgu1);
            
            preparedstatement.setInt(1, urun_id);
            
            ResultSet rs=preparedstatement.executeQuery();
       
            //while(rs.next()) durum++;
         
                if(durum==0){
                            
                    preparedstatement=con.prepareStatement(sorgu2);
            
                    preparedstatement.setInt(1,urun_id);
                    preparedstatement.setInt(2, miktar);
                    preparedstatement.setString(3, tarih);
                    preparedstatement.setInt(4, miktar);
                    preparedstatement.setInt(5, (genel_toplam+miktar));
                    
                    double sonuc=(miktar+genel_toplam)*(kar/100.0);
                    double sonuc2=(genel_toplam+sonuc)/miktar;
                    
                    preparedstatement.setDouble(6, sonuc2);;
             
                    preparedstatement.executeUpdate();
            }
            else{
                preparedstatement=con.prepareStatement(sorgu3);
                
                preparedstatement.setInt(1, miktar);
                preparedstatement.setInt(2, genel_toplam);
                
                double sonuc=genel_toplam*(kar/100.0);
             
                preparedstatement.setDouble(3, genel_toplam+sonuc);
                preparedstatement.setInt(4, urun_id);
                
                preparedstatement.executeUpdate();
            }
            
            preparedstatement=con.prepareStatement(sorgu4);
           
            preparedstatement.setInt(1,miktar);
            preparedstatement.setInt(2,urun_id);
                  
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void tedarikci_ekle(String firma_adi,String sehir,String ulke,int uzaklik){
        String sorgu="INSERT INTO `t_firma_bilgisi` (`firma_id`, `firma_adi`, `sehir`, `ulke`, `uzaklık`) VALUES (NULL, ?,? , ?, ?)";
        
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setString(1,firma_adi);
            preparedstatement.setString(2, sehir);
            preparedstatement.setString(3, ulke);
            preparedstatement.setInt(4, uzaklik);
            
            preparedstatement.executeUpdate();
               
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void t_anatablo_ekle(int firma_id,int miktar,int satis,String hammadde,String tarih){
        
        String sorgu="SELECT m_id FROM `t_madde_bilgisi` WHERE hammadde LIKE '"+hammadde+"'";
        String sorgu2="INSERT INTO `t_ana_tablo` (`firma_id`, `m_id`, `miktar`, `uretim_tarihi`, `satıs`) VALUES (?,?,?,?,?)";
        int m_id=0;
        try {
            statement=con.createStatement();
            
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next())
                m_id=rs.getInt("m_id");
            if(m_id==0){
                uyari2="";
                uyari2=hammadde+" adli ürünün üretimi bulunmamaktadır";
                return;
            }
    
            preparedstatement=con.prepareStatement(sorgu2);
            
            preparedstatement.setInt(1,firma_id);
            preparedstatement.setInt(2, m_id);
            preparedstatement.setInt(3, miktar);
            preparedstatement.setString(4, tarih);
            preparedstatement.setInt(5, satis);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Adresin daha önce olup olmadığını kontrol ediyor eğer varsa tekrar aynı satırdan oluşturmamızı engellemek için kullanıcaz
    public int adres_kontrol(String sehir,String ulke,int uzaklik){
        
        String sorgu="SELECT * FROM `yol_bilgi` WHERE sehir LIKE ? AND ulke LIKE ? ";
        int y_id=0;
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setString(1, sehir);
            preparedstatement.setString(2, ulke);
            
            ResultSet rs= preparedstatement.executeQuery();
            
            while(rs.next())
                y_id=rs.getInt("y_id");
       
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return y_id;
    }
    //Eğer yeni bir adres ise oluşturuyor.Eğer değil ise sadece adresin y_id dönüyor
    public int adres_ekle(String sehir,String ulke,int uzaklik){
        
            String sorgu="INSERT INTO `yol_bilgi` (`y_id`, `sehir`, `ulke`, `uzaklık`) VALUES (NULL, ?, ?, ?);";
            int y_id=adres_kontrol(sehir,ulke,uzaklik);
            
        
             //Daha önce olmayan bir bölge
            try {
                    
                if(y_id==0){
                    preparedstatement=con.prepareStatement(sorgu);
                    
                    preparedstatement.setString(1, sehir);
                    preparedstatement.setString(2, ulke);
                    preparedstatement.setInt(3, uzaklik);
                
                    preparedstatement.executeUpdate();
                    y_id=adres_kontrol(sehir,ulke,uzaklik);
                }                    
            }
            catch (SQLException ex) {
                Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
                }
            return y_id;
    }
    public void musteri_ekle(String musteri_adi,String adres,int y_id){
        
        String sorgu="INSERT INTO `musteri` (`musteri_id`, `musteri_adi`, `Adres`, `y_id`) VALUES (NULL, ?, ?, ?);";
        
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setString(1,musteri_adi);
            preparedstatement.setString(2,adres);
            preparedstatement.setInt(3, y_id);
              
            preparedstatement.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void urun_detay_guncelle(int sıra,int stok){
        
            String sorgu="UPDATE `urun_bilgisi_detay` SET `Stok` = ? WHERE `urun_bilgisi_detay`.`Sıra` = ?;";
            
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, stok);
            preparedstatement.setInt(2, sıra);
            
            preparedstatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void musteri_urun_al(String urun_adi,int miktar,int musteri_id,int durum){
        String sorgu1="SELECT * FROM `urun_bilgisi` WHERE urun_adı LIKE '"+urun_adi+"'";
        String sorgu2="SELECT * FROM `urun_bilgisi_detay` WHERE urun_ıd=? AND Stok>0";
        //String sorgu3="INSERT INTO `m_urun_bilgisi` (`musteri_id`, `urun_id`, `urun_adi`, `alıs_fiyati`, `stok`) VALUES (?,?,?,?,?)";
        int urun_id=0,toplam_fiyat=0;
        int t_stok=miktar;
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu1);
            
            while(rs.next())
                urun_id=rs.getInt("urun_ıd");
            
            preparedstatement=con.prepareStatement(sorgu2);
            
            preparedstatement.setInt(1,urun_id);
            
            rs=preparedstatement.executeQuery();
            
            while(rs.next()){
                
               int t_miktar=rs.getInt("Stok");
               int fiyat=rs.getInt("satıs_fiyatı");
               int a_fiyatı=rs.getInt("top_maliyet");
               int sıra=rs.getInt("sıra");
               int alıs=rs.getInt("top_maliyet");
               
               //int kar2=fiyat-a_fiyatı;
            //t_miktar sıfırdan küçük olduğunda miktarı karşılayamış oluyor!!!!!!!   
            t_miktar-=miktar;
            float birim = alıs/fiyat;
                float kar=(fiyat-birim)*miktar;
                urun_bazında_kar(urun_id, kar);
                if(t_miktar==0||t_miktar>0){
                    toplam_fiyat+=fiyat*miktar;
                    System.out.println("Ürün bilgisi:1--->miktar:"+ miktar);
                    
                    urun_bilgisi_guncelle(urun_id, miktar,durum);
                    musteri_bazında_kar(urun_id, musteri_id, kar);
                    urun_detay_guncelle(sıra, t_miktar);
                    //u_tablo_gun(m_id, toplam_alım,genel_toplam,tarih2);
                    musteri_urun_tablosu_ekle(musteri_id, urun_id, urun_adi, toplam_fiyat, t_stok);
                    return;
                }
                else if(t_miktar<0){
                    toplam_fiyat+=fiyat*miktar;
                    System.out.println("Ürün bilgisi:2--->miktar:"+ miktar);
                    miktar=Math.abs(t_miktar);
                    urun_bilgisi_guncelle(urun_id, miktar,durum);
                    musteri_bazında_kar(urun_id, musteri_id, kar);
                    urun_detay_guncelle(sıra, 0);
               //tablo_guncelle(f_id, m_id,0); 
                 }
          }
            //System.out.println("geldidididiiddididi");
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void musteri_urun_tablosu_ekle(int musteri_id,int urun_id,String urun_adi,int alis_fiyati,int stok){
        
        String sorgu="INSERT INTO m_urun_bilgisi (musteri_id,urun_id,urun_adi,alıs_fiyati,stok) VALUES (?,?,?,?,?)";
        
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, musteri_id);
            preparedstatement.setInt(2, urun_id);
            preparedstatement.setString(3,urun_adi);
            preparedstatement.setInt(4, alis_fiyati);
            preparedstatement.setInt(5, stok);
            
            preparedstatement.executeUpdate();
    
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void urun_bilgisi_guncelle(int urun_id,int alınan,int durum){
        
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //İki sorgu yapmamamın sebebi nedenini çözemediğim şekilde stok güncelleme yapmamasıdır
        
        
        String sorgu="SELECT Stok FROM `urun_bilgisi` WHERE urun_ıd=?";
        String sorgu2="UPDATE urun_bilgisi SET Stok=? WHERE urun_ıd=?";
        int stok=0;    
            
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setInt(1, urun_id);
            
            ResultSet rs=preparedstatement.executeQuery();
            
            while(rs.next())
                stok=rs.getInt("Stok");
  
            //System.out.println("ALINAN:"+alınan+"Stok"+stok);
            if(durum==0){
                stok-=alınan;
            }
            else if(stok!=0)
                stok-=alınan;
            preparedstatement=con.prepareStatement(sorgu2);
            
            preparedstatement.setInt(1, stok);
            preparedstatement.setInt(2, urun_id);
            
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int musteri_eksik_hammade(String[] bil,int[] adet,int sayac,int miktar){
        genel_toplam=0;toplam_alım=0;
        //Eldeki stoğun adedini bul
        String sorgu1="SELECT m_id FROM t_madde_bilgisi WHERE hammadde LIKE ?";
        String sorgu2="SELECT SUM(stok_durumu) FROM `u_anatablo` WHERE m_id=?";
        int m_id=0,toplam_stok=0,ihtiyac=0,durum;
        for(int i=0;i<sayac;i++){
            if(adet[i]==0) adet[i]=1;
            ihtiyac=adet[i]*miktar;
            try {
                preparedstatement=con.prepareStatement(sorgu1);
            
                preparedstatement.setString(1,bil[i]);
                
                ResultSet rs=preparedstatement.executeQuery();
                
                while(rs.next())
                    m_id=rs.getInt("m_id");
                
                preparedstatement=con.prepareStatement(sorgu2);
                
                preparedstatement.setInt(1,m_id);
                
                rs=preparedstatement.executeQuery();
                
                while(rs.next())
                    toplam_stok=rs.getInt(1);
                
                /*if(toplam_stok<ihtiyac){
                    uyari3+=("Tedarikçide "+(ihtiyac-toplam_stok)+"tane "+bil[i]+" eksik\nİslem durduruldu\n") ;
                    return 9999;
                }  */ 
                    
                //System.out.println("-------------------->>>>>Toplam Stok:   "+toplam_stok);
                if((toplam_stok-ihtiyac)<0){
                    ihtiyac-=toplam_stok;
                    //System.out.println("--->>Bil: "+bil[i]+"--->>>ihtiyac:  "+ihtiyac);
                    durum=p1_urun_al(bil[i], ihtiyac);
                    while(durum!=0&&durum!=9999){
                             ihtiyac=Math.abs(durum);
                             durum=p1_urun_al(bil[i], ihtiyac);
                              /*if(toplam_stok<ihtiyac){  
                                uyari3+=("Tedarikçide "+(ihtiyac-toplam_stok)+"tane "+bil[i]+" eksik\nİslem durduruldu\n") ;
                                return 9999;
                             } */ 
                        }
                    //System.out.println("DURURMRMRRMRM->>>>>>>>>>>>>>>>>:"+durum);
                    if(durum==9999){
                        return 9999;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }   
        return 1;
    }
    public void urun_bazında_kar(int urun_id,float kar){
        
        String sorgu="UPDATE `urun_bilgisi` SET kar=kar+? WHERE urun_ıd=?";
        
        try {
            preparedstatement=con.prepareStatement(sorgu);
            
            preparedstatement.setFloat(1, kar);
            preparedstatement.setInt(2, urun_id);
            
            preparedstatement.executeUpdate();    
        }
        catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void musteri_bazında_kar(int urun_id,int musteri_id,float kar){
        String sorgu="SELECT * FROM `musteri_kar` WHERE musteri_id=? AND urun_id=?";
        String sorgu2="INSERT INTO `musteri_kar` (`musteri_id`, `urun_id`, `kar`) VALUES (?,?,?);";      
        String sorgu3="UPDATE `musteri_kar` SET kar =? WHERE musteri_id=? AND urun_id=?";
        int durum=0;
        try {
            preparedstatement=con.prepareStatement(sorgu);
           
            preparedstatement.setInt(1, musteri_id);
            preparedstatement.setInt(2, urun_id);
            
            ResultSet rs=preparedstatement.executeQuery();
            
            while(rs.next())
            durum++;
            
            System.out.println("DURUM:  "+durum);
            if(durum==0){
                preparedstatement=con.prepareStatement(sorgu2);
                
                preparedstatement.setInt(1, musteri_id);
                preparedstatement.setInt(2, urun_id);
                preparedstatement.setFloat(3, kar);
                
                preparedstatement.executeUpdate();
                
            }
            else{
                preparedstatement=con.prepareStatement(sorgu3);
                
                preparedstatement.setInt(1, musteri_id);
                preparedstatement.setInt(2, urun_id);
                preparedstatement.setFloat(3, kar);
                
                preparedstatement.executeUpdate();
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(İslemler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
}
