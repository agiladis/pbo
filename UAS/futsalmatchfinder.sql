-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jun 2021 pada 15.23
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `futsalmatchfinder`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(255) NOT NULL,
  `nama_customer` varchar(255) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id_customer`, `nama_customer`, `no_telp`) VALUES
(1, 'Katon', '021491241'),
(2, 'Alex', '0214714712'),
(3, 'Michael', '021 419472174'),
(4, 'Mario', '08947216492');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lapangan`
--

CREATE TABLE `lapangan` (
  `id_lapangan` int(255) NOT NULL,
  `nama_lapangan` varchar(255) NOT NULL,
  `lokasi_lapangan` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `nama_vendor` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `lapangan`
--

INSERT INTO `lapangan` (`id_lapangan`, `nama_lapangan`, `lokasi_lapangan`, `harga`, `nama_vendor`) VALUES
(1, 'Estadio', 'Bekasi', 100000, 'Test2'),
(2, 'Red Soccer', 'Karawang', 85000, 'Neo'),
(3, 'Planet', 'Jakarta', 90000, 'Neo');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tim`
--

CREATE TABLE `tim` (
  `id_tim` int(255) NOT NULL,
  `nama_tim` varchar(255) NOT NULL,
  `lokasi_tim` varchar(255) NOT NULL,
  `telp_tim` varchar(255) NOT NULL,
  `jadwal` date NOT NULL,
  `nama_customer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tim`
--

INSERT INTO `tim` (`id_tim`, `nama_tim`, `lokasi_tim`, `telp_tim`, `jadwal`, `nama_customer`) VALUES
(1, 'MU', 'Bekasi', '021 479461242', '2021-06-24', 'Katon');

-- --------------------------------------------------------

--
-- Struktur dari tabel `vendor`
--

CREATE TABLE `vendor` (
  `id_vendor` int(255) NOT NULL,
  `nama_vendor` varchar(255) NOT NULL,
  `telp_vendor` varchar(255) NOT NULL,
  `lokasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `vendor`
--

INSERT INTO `vendor` (`id_vendor`, `nama_vendor`, `telp_vendor`, `lokasi`) VALUES
(123, 'Neo', '021 12408124', 'Bekasi'),
(234, 'Juki', '021 45789753', 'Jakarta'),
(324, 'Test2', '021 58592752', 'Bandung');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`),
  ADD UNIQUE KEY `id_customer` (`id_customer`),
  ADD KEY `nama_customer` (`nama_customer`);

--
-- Indeks untuk tabel `lapangan`
--
ALTER TABLE `lapangan`
  ADD PRIMARY KEY (`id_lapangan`),
  ADD UNIQUE KEY `id_lapangan` (`id_lapangan`),
  ADD KEY `nama_vendor` (`nama_vendor`);

--
-- Indeks untuk tabel `tim`
--
ALTER TABLE `tim`
  ADD PRIMARY KEY (`id_tim`),
  ADD UNIQUE KEY `id_tim` (`id_tim`),
  ADD KEY `nama_customer` (`nama_customer`);

--
-- Indeks untuk tabel `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id_vendor`),
  ADD UNIQUE KEY `id_vendor` (`id_vendor`),
  ADD KEY `nama_vendor` (`nama_vendor`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `lapangan`
--
ALTER TABLE `lapangan`
  ADD CONSTRAINT `lapangan_ibfk_1` FOREIGN KEY (`nama_vendor`) REFERENCES `vendor` (`nama_vendor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tim`
--
ALTER TABLE `tim`
  ADD CONSTRAINT `tim_ibfk_1` FOREIGN KEY (`nama_customer`) REFERENCES `customer` (`nama_customer`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
