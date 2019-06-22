-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 22 Haz 2019, 19:37:09
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 7.2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `prolab2.3`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteri`
--

CREATE TABLE `musteri` (
  `musteri_id` int(11) NOT NULL,
  `musteri_adi` text COLLATE utf8_turkish_ci NOT NULL,
  `Adres` text COLLATE utf8_turkish_ci NOT NULL,
  `y_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `musteri`
--

INSERT INTO `musteri` (`musteri_id`, `musteri_adi`, `Adres`, `y_id`) VALUES
(1, 'Mert', 'Ornek mh. ornek sk. no:20', 4),
(5, 'Deneme', 'deneme sk deneme mah. ', 3),
(6, 'Deneme', 'Deneme', 10);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteri_kar`
--

CREATE TABLE `musteri_kar` (
  `musteri_id` int(11) NOT NULL,
  `urun_id` int(11) NOT NULL,
  `kar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `musteri_kar`
--

INSERT INTO `musteri_kar` (`musteri_id`, `urun_id`, `kar`) VALUES
(1, 2, 74),
(1, 3, 194),
(6, 2, 22),
(5, 3, 140);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `m_urun_bilgisi`
--

CREATE TABLE `m_urun_bilgisi` (
  `musteri_id` int(11) NOT NULL,
  `urun_id` int(11) NOT NULL,
  `urun_adi` text COLLATE utf8_turkish_ci NOT NULL,
  `alıs_fiyati` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `m_urun_bilgisi`
--

INSERT INTO `m_urun_bilgisi` (`musteri_id`, `urun_id`, `urun_adi`, `alıs_fiyati`, `stok`) VALUES
(1, 2, 'CO2', 52, 2),
(1, 3, 'SO2', 148, 2),
(6, 2, 'CO2', 26, 1),
(5, 3, 'SO2', 148, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `t_ana_tablo`
--

CREATE TABLE `t_ana_tablo` (
  `firma_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL,
  `miktar` int(11) NOT NULL,
  `uretim_tarihi` text COLLATE utf8_turkish_ci NOT NULL,
  `satıs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `t_ana_tablo`
--

INSERT INTO `t_ana_tablo` (`firma_id`, `m_id`, `miktar`, `uretim_tarihi`, `satıs`) VALUES
(1, 4, 100, '27052019', 8),
(1, 3, 300, '27052019', 9),
(1, 1, 150, '27052019', 10),
(1, 2, 400, '27052019', 11),
(1, 5, 200, '27052019', 12),
(1, 6, 200, '27052019', 13),
(2, 4, 10, '27052019', 1),
(2, 3, 15, '27052019', 2),
(2, 1, 20, '27052019', 3),
(3, 4, 140, '27052019', 3),
(3, 3, 190, '27052019', 4),
(3, 1, 150, '27052019', 5),
(3, 5, 190, '27052019', 6),
(3, 6, 200, '27052019', 7),
(4, 4, 1000, '27052019', 10),
(4, 3, 3000, '27052019', 11),
(4, 1, 2000, '27052019', 12),
(4, 2, 1000, '27052019', 13),
(4, 5, 1000, '27052019', 14),
(4, 6, 1000, '27052019', 14),
(5, 4, 50, '27052019', 7),
(5, 1, 50, '27052019', 8),
(5, 2, 50, '27052019', 9),
(5, 3, 50, '27052019', 10),
(6, 4, 30, '27052019', 5),
(6, 3, 30, '27052019', 6),
(6, 1, 30, '27052019', 7),
(6, 2, 0, '27052019', 7),
(6, 5, 30, '27052019', 8),
(6, 6, 10, '27052019', 8),
(7, 4, 1000, '27052019', 20),
(7, 3, 1000, '27052019', 25),
(7, 1, 1000, '27052019', 30),
(8, 4, 500, '27052019', 7),
(8, 3, 1000, '27052019', 8),
(8, 2, 2000, '27052019', 9),
(8, 5, 600, '27052019', 10),
(8, 1, 1000, '27052019', 11),
(9, 4, 100, '27052019', 3),
(9, 3, 300, '27052019', 4),
(9, 1, 200, '27052019', 5),
(9, 2, 300, '27052019', 6),
(9, 5, 100, '27052019', 7),
(9, 6, 100, '27052019', 8),
(10, 4, 10, '27052019', 1),
(10, 1, 5, '27052019', 2),
(10, 2, 5, '27052019', 3),
(10, 5, 10, '27052019', 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `t_firma_bilgisi`
--

CREATE TABLE `t_firma_bilgisi` (
  `firma_id` int(11) NOT NULL,
  `firma_adi` text COLLATE utf8_turkish_ci NOT NULL,
  `sehir` text COLLATE utf8_turkish_ci NOT NULL,
  `ulke` text COLLATE utf8_turkish_ci NOT NULL,
  `uzaklık` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `t_firma_bilgisi`
--

INSERT INTO `t_firma_bilgisi` (`firma_id`, `firma_adi`, `sehir`, `ulke`, `uzaklık`) VALUES
(1, 'ANK1', 'Ankara', 'Türkiye', 342),
(2, 'ESK1', 'Eskisehir', 'Türkiye', 214),
(3, 'Gaz1', 'Gaziantep', 'Türkiye', 1000),
(4, 'IST1', 'İstanbul', 'Türkiye', 111),
(5, 'IST2', 'İstanbul', 'Türkiye', 111),
(6, 'IST3', 'İstanbul', 'Türkiye', 111),
(7, 'LON1', 'Londra', 'İngiltere', 2582),
(8, 'BER1', 'Berlin', 'Almanya', 1809),
(9, 'BER2', 'Berlin', 'Almanya', 1809),
(10, 'SB1', 'Saraybosna', 'Bosna Hersek', 1008);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `t_madde_bilgisi`
--

CREATE TABLE `t_madde_bilgisi` (
  `m_id` int(11) NOT NULL,
  `hammadde` text COLLATE utf8_turkish_ci NOT NULL,
  `raf_omru` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `t_madde_bilgisi`
--

INSERT INTO `t_madde_bilgisi` (`m_id`, `hammadde`, `raf_omru`) VALUES
(1, 'C', 10),
(2, 'O', 11),
(3, 'H', 9),
(4, 'N', 8),
(5, 'S', 12),
(6, 'CL', 13);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urun_bilgisi`
--

CREATE TABLE `urun_bilgisi` (
  `urun_ıd` int(11) NOT NULL,
  `urun_adı` text COLLATE utf8_turkish_ci NOT NULL,
  `bilesenleri` text COLLATE utf8_turkish_ci NOT NULL,
  `Stok` int(11) NOT NULL,
  `raf_omru` int(11) NOT NULL,
  `kar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `urun_bilgisi`
--

INSERT INTO `urun_bilgisi` (`urun_ıd`, `urun_adı`, `bilesenleri`, `Stok`, `raf_omru`, `kar`) VALUES
(1, 'NH3', 'N-H3', 0, 3, 0),
(2, 'CO2', 'C-O2', 2, 5, 96),
(3, 'SO2', 'S-O2', 1, 6, 334),
(4, 'C6H12O6', 'C-H-O', 0, 9, 0),
(5, 'HCL', 'H-CL', 0, 9, 0),
(9, 'H2O', 'H-O', 0, 9, 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urun_bilgisi_detay`
--

CREATE TABLE `urun_bilgisi_detay` (
  `Sıra` int(11) NOT NULL,
  `urun_ıd` int(11) NOT NULL,
  `Stok` int(11) NOT NULL,
  `uretim_tarihi` int(11) NOT NULL,
  `is_maliyeti` int(11) NOT NULL,
  `top_maliyet` int(11) NOT NULL,
  `satıs_fiyatı` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `urun_bilgisi_detay`
--

INSERT INTO `urun_bilgisi_detay` (`Sıra`, `urun_ıd`, `Stok`, `uretim_tarihi`, `is_maliyeti`, `top_maliyet`, `satıs_fiyatı`) VALUES
(46, 2, 2, 22062019, 5, 126, 26.72),
(47, 3, 1, 22062019, 5, 342, 74.24),
(50, 1, 0, 22062019, 2, 2, 0.2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `u_anatablo`
--

CREATE TABLE `u_anatablo` (
  `id` int(11) NOT NULL,
  `firma_id` int(11) NOT NULL,
  `m_id` int(11) NOT NULL,
  `stok_durumu` int(11) NOT NULL,
  `alıs_fiyatı` int(11) NOT NULL,
  `SKT` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `u_anatablo`
--

INSERT INTO `u_anatablo` (`id`, `firma_id`, `m_id`, `stok_durumu`, `alıs_fiyatı`, `SKT`) VALUES
(69, 100, 1, 47, 226, '27052029'),
(70, 100, 2, 16, 204, '27052030'),
(71, 100, 6, 30, 253, '27052032'),
(72, 100, 5, 6, 180, '27052031'),
(73, 100, 4, 8, 361, '27052027'),
(74, 100, 3, 4, 626, '27052028');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `u_firma_bilgisi`
--

CREATE TABLE `u_firma_bilgisi` (
  `firma_id` int(11) NOT NULL,
  `firma_adi` text COLLATE utf8_turkish_ci NOT NULL,
  `sehir` text COLLATE utf8_turkish_ci NOT NULL,
  `Ulke` text COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `u_firma_bilgisi`
--

INSERT INTO `u_firma_bilgisi` (`firma_id`, `firma_adi`, `sehir`, `Ulke`) VALUES
(100, 'P Kimya Üretim', 'Kocaeli', 'Türkiye');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yol_bilgi`
--

CREATE TABLE `yol_bilgi` (
  `y_id` int(11) NOT NULL,
  `sehir` text COLLATE utf8_turkish_ci NOT NULL,
  `ulke` text COLLATE utf8_turkish_ci NOT NULL,
  `uzaklık` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `yol_bilgi`
--

INSERT INTO `yol_bilgi` (`y_id`, `sehir`, `ulke`, `uzaklık`) VALUES
(1, 'Ankara', 'Türkiye', 342),
(2, 'Eskisehir', 'Türkiye', 214),
(3, 'Gaziantep', 'Türkiye', 1000),
(4, 'İstanbul', 'Türkiye', 111),
(5, 'Londra', 'İngiltere', 2582),
(6, 'Berlin', 'Almanya', 1809),
(7, 'Saraybosna', 'Bosna Hersek', 1008),
(10, 'Deneme', 'Deneme', 123);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `musteri`
--
ALTER TABLE `musteri`
  ADD PRIMARY KEY (`musteri_id`);

--
-- Tablo için indeksler `t_firma_bilgisi`
--
ALTER TABLE `t_firma_bilgisi`
  ADD PRIMARY KEY (`firma_id`);

--
-- Tablo için indeksler `t_madde_bilgisi`
--
ALTER TABLE `t_madde_bilgisi`
  ADD PRIMARY KEY (`m_id`);

--
-- Tablo için indeksler `urun_bilgisi`
--
ALTER TABLE `urun_bilgisi`
  ADD PRIMARY KEY (`urun_ıd`);

--
-- Tablo için indeksler `urun_bilgisi_detay`
--
ALTER TABLE `urun_bilgisi_detay`
  ADD PRIMARY KEY (`Sıra`);

--
-- Tablo için indeksler `u_anatablo`
--
ALTER TABLE `u_anatablo`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `u_firma_bilgisi`
--
ALTER TABLE `u_firma_bilgisi`
  ADD PRIMARY KEY (`firma_id`);

--
-- Tablo için indeksler `yol_bilgi`
--
ALTER TABLE `yol_bilgi`
  ADD PRIMARY KEY (`y_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `musteri`
--
ALTER TABLE `musteri`
  MODIFY `musteri_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `t_firma_bilgisi`
--
ALTER TABLE `t_firma_bilgisi`
  MODIFY `firma_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Tablo için AUTO_INCREMENT değeri `t_madde_bilgisi`
--
ALTER TABLE `t_madde_bilgisi`
  MODIFY `m_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `urun_bilgisi`
--
ALTER TABLE `urun_bilgisi`
  MODIFY `urun_ıd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `urun_bilgisi_detay`
--
ALTER TABLE `urun_bilgisi_detay`
  MODIFY `Sıra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Tablo için AUTO_INCREMENT değeri `u_anatablo`
--
ALTER TABLE `u_anatablo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- Tablo için AUTO_INCREMENT değeri `u_firma_bilgisi`
--
ALTER TABLE `u_firma_bilgisi`
  MODIFY `firma_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Tablo için AUTO_INCREMENT değeri `yol_bilgi`
--
ALTER TABLE `yol_bilgi`
  MODIFY `y_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
