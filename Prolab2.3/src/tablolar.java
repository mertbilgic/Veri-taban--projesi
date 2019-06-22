class p1_tablo{
    
    private int firma_id;
    private int urun_id;
    private String urun_adi;
    private String bilesen;
    private String firma_adi;
    private String sehir;
    private String hammade;
    private int miktar;
    private int maliyet;
    private int kargo;
    private String ulke;
    private int m_id;
    private String tarih;
    private int raf_omru;
    private int i_maliyeti;
    private int satis;
    private String adres;
    private String musteri_adi;
    private int y_id;
    private int musteri_id;
    private int kar;
    
   
    
    public p1_tablo (int musteri_id,int urun_id,int kar){
        this.musteri_id=musteri_id;
        this.urun_id=urun_id;
        this.kar=kar;
    }
    public p1_tablo (int y_id,int uzaklık,String sehir,String ulke){
       this.y_id=y_id;
       this.kargo=uzaklık;
       this.sehir=sehir;
       this.ulke=ulke;   
   }
    public p1_tablo(int urun_ıd,String urun_adı,int kar,String bilesen){
        this.urun_id=urun_ıd;
        this.urun_adi=urun_adı;
        this.kar=kar;
        this.bilesen=bilesen;
        
    }
     
   public p1_tablo (int musteri_id,String musteri_adi,String adres,int y_id){
       this.musteri_id=musteri_id;
       this.musteri_adi=musteri_adi;
       this.adres=adres;
       this.y_id=y_id; 
   }
   public p1_tablo(int musteri_id,int urun_id,String urun_adi,int maliyet,int stok){
       this.musteri_id=musteri_id;
       this.urun_id=urun_id;
       this.urun_adi=urun_adi;
       this.maliyet=maliyet;
       this.miktar=stok;
       
   }
   
    public p1_tablo(int firma_id,String firma_adi,String sehir,String ulke,int uzaklık){
        this.firma_id=firma_id;
        this.firma_adi=firma_adi;
        this.sehir=sehir;
        this.ulke=ulke;
        this.kargo=uzaklık;
    }
    
    public p1_tablo(int urun_id,String urun_adi,String bilesenleri,int stok,int raf_omru){
        this.urun_id=urun_id;
        this.urun_adi=urun_adi;
        this.bilesen=bilesenleri;
        this.miktar=stok;
        this.raf_omru=raf_omru;        
    }

    public p1_tablo(int firma_id,int m_id,String hammade,int stok_durumu,int alis_fiyati,String tarih){
        this.firma_id=firma_id;
        this.m_id=m_id;
        this.hammade=hammade;
        this.miktar=stok_durumu;
        this.maliyet=alis_fiyati;
        this.tarih=tarih;    
    }
    
    public p1_tablo (int musteri_id,String musteri_adi,String adres,String sehir,String ulke,int uzaklik){
       this.musteri_id=musteri_id;
       this.musteri_adi=musteri_adi;
       this.adres=adres;
       this.sehir=sehir;
       this.ulke=ulke;
       this.kargo =uzaklik;
   
    }
    
    public p1_tablo(int urun_id,String urun_adi,String bilesen,int stok,String tarih,int raf_o,int i_maliyet,int maliyet,int satis){
        this.urun_id=urun_id;
        this.urun_adi=urun_adi;
        this.bilesen=bilesen;
        this.tarih=tarih;
        this.raf_omru=raf_o;
        this.i_maliyeti=i_maliyet;
        this.maliyet=maliyet;
        this.satis=satis;
        this.miktar=stok;
    }
    
       
    public p1_tablo(int firma_id,String firma_adi,String hammade,int miktar,int maliyet,int kargo,String ulke,int m_id,int raf_omru,String tarih){
        this.firma_id=firma_id;
        this.firma_adi=firma_adi;
        this.hammade=hammade;
        this.miktar=miktar;
        this.maliyet=maliyet;
        this.kargo=kargo;
        this.ulke=ulke;
        this.m_id=m_id;
        this.raf_omru=raf_omru;
        this.tarih=tarih;
    }

    public int getKar() {
        return kar;
    }

    public void setKar(int kar) {
        this.kar = kar;
    }
    

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }
    
    
    
    public String getMusteri_adi() {
        return musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
    }
    

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getY_id() {
        return y_id;
    }

    public void setY_id(int y_id) {
        this.y_id = y_id;
    }
    
    
    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getBilesen() {
        return bilesen;
    }

    public void setBilesen(String bilesen) {
        this.bilesen = bilesen;
    }

    public int getI_maliyeti() {
        return i_maliyeti;
    }

    public void setI_maliyeti(int i_maliyeti) {
        this.i_maliyeti = i_maliyeti;
    }

    public int getSatis() {
        return satis;
    }

    public void setSatis(int satis) {
        this.satis = satis;
    }
    
    
    
    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getRaf_omru() {
        return raf_omru;
    }

    public void setRaf_omru(int raf_omru) {
        this.raf_omru = raf_omru;
    }
    
    
    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }
    
    
    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }
    

    public int getKargo() {
        return kargo;
    }

    public void setKargo(int kargo) {
        this.kargo = kargo;
    }

    public int getMaliyet() {
        return maliyet;
    }

    public void setMaliyet(int maliyet) {
        this.maliyet = maliyet;
    }

    public int getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }

    public String getFirma_adi() {
        return firma_adi;
    }

    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public String getHammade() {
        return hammade;
    }

    public void setHammade(String hammade) {
        this.hammade = hammade;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    
}

public class tablolar {
   
 
}
