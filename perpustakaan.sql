-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Des 2018 pada 10.34
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`username`, `password`, `fname`, `lname`, `alamat`, `id`) VALUES
('Angga', 'Angga', '', '', '', 1),
('pace', '12345', 'angaa', 'maulana', 'hahahaha', 2),
('anggama', '12345', 'angga', 'maulana', '', 3),
('ahmadma', '12345', 'ahmad', 'ma', 'jalan ikan mati', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `idbuku` int(15) NOT NULL,
  `kategori` varchar(100) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `jml_buku` int(11) NOT NULL,
  `harga_sat` int(15) NOT NULL,
  `dendaKeterlambatan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`idbuku`, `kategori`, `judul`, `jml_buku`, `harga_sat`, `dendaKeterlambatan`) VALUES
(1, 'Komik', 'Marnia', 12, 10000, 2000),
(2, 'Novel', 'Lisa 1996', 9, 10000, 2500),
(3, 'Novel', 'Negeri 5 Menara', 5, 7500, 2000),
(4, 'Novel', 'Negri 1 Muara', 6, 9700, 2000),
(5, 'Novel', 'Twilight', 23, 7600, 2600),
(6, 'Politik', 'Kinerja Joko Widodo', 11, 6700, 2550),
(7, 'Politik', 'Kerasnya Orde Baru', 6, 8900, 1900),
(8, 'Politik', 'Partai Politik', 13, 5000, 2500),
(10, 'Politik', 'Kinerja DPR-RI', 9, 7800, 1800),
(11, 'Politik', 'Perkembangan Papua', 7, 7800, 1900),
(12, 'Sejarah', 'Kejayaan Majapahit', 10, 5400, 2900),
(13, 'Sejarah', 'Kerajaan Demak', 4, 6500, 2500),
(15, 'Sejarah', '3,5 Abad Penjajahan Belanda', 39, 9200, 2300),
(16, 'Sejarah', 'Berdirinya Kerajaan Samudra Pasai', 2, 9700, 2250),
(17, 'Legenda', 'Danau Toba', 1, 6700, 2250),
(18, 'Legenda', 'Buaya Putih', 12, 5400, 2350),
(19, 'Legenda', 'Buaya Darat', 18, 9300, 2150),
(20, 'Legenda', 'Terbentuknya Sungai Kapuas', 18, 7600, 2450),
(21, 'Legenda', 'Naga Langit', 35, 4500, 1950),
(22, 'Biografi', 'Pabowo Subianto', 11, 7600, 1900),
(23, 'Biografi', 'Kesederhanaan Joko Widodo', 22, 9100, 2850),
(24, 'Biografi', 'KH. Hasyim Asyari', 3, 6000, 1900),
(25, 'Biografi', 'Keberanian Bung Tomo', 16, 6800, 2800),
(26, 'Biografi', 'Gus Dur', 2, 4500, 1950),
(28, 'Komik', 'Uzumaki Sakura', 21, 7500, 1900),
(29, 'Novel', 'Kisah Bambank', 25, 6000, 1200);

-- --------------------------------------------------------

--
-- Struktur dari tabel `datatransaksi`
--

CREATE TABLE `datatransaksi` (
  `id` int(11) NOT NULL,
  `nomorPeminjam` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `tanggalpinjam` date NOT NULL,
  `tanggalkembali` date NOT NULL,
  `lamaPinjam` int(15) NOT NULL,
  `biaya` int(100) NOT NULL,
  `dendaKeterlambatan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datatransaksi`
--

INSERT INTO `datatransaksi` (`id`, `nomorPeminjam`, `nama`, `judul`, `tanggalpinjam`, `tanggalkembali`, `lamaPinjam`, `biaya`, `dendaKeterlambatan`) VALUES
(1, 10, 'sfa', 'asdd', '2018-12-17', '2018-12-17', 14, 1212, 13),
(2, 13, 'sfa', '0', '1999-09-20', '2009-02-19', 14, 12, 13),
(3, 19, 'joa', '0', '2018-07-09', '2018-12-26', 1, 200, 199),
(4, 18121901, ' Albert', 'Lisa 1996', '2018-12-19', '2019-01-11', 23, 10000, 2500),
(5, 18121902, ' koko', 'Buaya Putih', '2018-12-19', '2018-12-28', 9, 5400, 2350),
(6, 18121903, ' Jennie-Kim', '3,5 Abad Penjajahan Belanda', '2018-12-19', '2018-12-26', 7, 9200, 2300),
(7, 18121904, ' Test', 'Berdirinya Kerajaan Samudra Pasai', '2018-12-19', '2018-12-31', 12, 9700, 2250),
(8, 18121905, ' Test', 'Berdirinya Kerajaan Samudra Pasai', '2018-12-19', '2018-12-21', 2, 9700, 2250),
(9, 18121906, ' lolo', '3,5 Abad Penjajahan Belanda', '2018-12-19', '2018-12-29', 10, 9200, 2300),
(10, 18121907, ' lolo', '3,5 Abad Penjajahan Belanda', '2018-12-19', '2018-12-31', 12, 9200, 2300),
(11, 18121908, ' Test1', 'Lisa 1996', '2018-12-19', '2018-12-20', 1, 10000, 2500),
(12, 18121909, ' Test1', 'Lisa 1996', '2018-12-19', '2018-12-21', 2, 20000, 2500),
(13, 18122000, ' pap', 'Kinerja Joko Widodo', '2018-12-20', '2018-12-22', 2, 13400, 2550),
(14, 18122001, ' jojo', 'Lisa 1996', '2018-12-20', '2018-12-22', 2, 20000, 2500),
(15, 18122002, ' kow', 'Kerajaan Demak', '2018-12-20', '2018-12-22', 2, 13000, 2500),
(16, 18122003, ' test12', 'Buaya Darat', '2018-12-20', '2018-12-27', 7, 65100, 2150),
(17, 18122004, ' arka', 'Lisa 1996', '2018-12-20', '2018-12-22', 2, 20000, 2500),
(18, 18122005, ' arka', 'Lisa 1996', '2018-12-20', '2018-12-21', 1, 10000, 2500),
(19, 18122006, ' arka', 'Lisa 1996', '2018-12-20', '2018-12-23', 3, 30000, 2500),
(20, 18122007, ' arka', 'Lisa 1996', '2018-12-20', '2018-12-22', 2, 20000, 2500),
(21, 18122100, ' Angga Maulana Jackson', 'Negri 1 Muara', '2018-12-21', '2018-12-29', 8, 77600, 2000),
(22, 18122101, ' Khoirul Arifin', 'Kerajaan Demak', '2018-12-21', '2018-12-28', 7, 45500, 2500),
(23, 18122102, ' Khoirul Arifin', 'Buaya Darat', '2018-12-21', '2018-12-29', 8, 74400, 2150);

-- --------------------------------------------------------

--
-- Struktur dari tabel `umum`
--

CREATE TABLE `umum` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `umum`
--

INSERT INTO `umum` (`username`, `password`, `fname`, `lname`, `alamat`, `id`) VALUES
('ahmad', 'ahmad', '', '', '', 1),
('angga', '12345', '', '', '', 8),
('tayo123', 'tayo123', 'ar', 'syad', 'jalan candi panggung barat', 9),
('jojo', 'jojo', 'jojo', 'jojo', 'jojo', 10),
('anggam', '12345', 'angga', 'maulana', '', 11),
('kintul', '1998', 'Khoirul', 'Arifin', 'Jl. Semanggi Barat No. 28', 13);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`idbuku`);

--
-- Indeks untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `umum`
--
ALTER TABLE `umum`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `idbuku` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT untuk tabel `umum`
--
ALTER TABLE `umum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
