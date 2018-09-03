-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2018 at 03:47 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `impal`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(50) NOT NULL,
  `nama_admin` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `jk_admin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `password`, `username`, `jk_admin`) VALUES
('ADM1', 'HAMAD', 'hamad', 'hamad', 'Laki-Laki'),
('ADM2', 'ROMY', 'romy', 'romy', 'Laki-Laki'),
('ADM3', 'HAFIDZ', 'hafidz', 'hafidz', 'Laki-Laki'),
('ADM4', 'YUDHA', 'yudha', 'yudha', 'Laki-Laki');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `stok_barang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jenis_barang`, `stok_barang`) VALUES
('BRG1', 'Magnesium', 'Bahan Baku', '12'),
('BRG2', 'Nikel', 'Bahan Baku', '20'),
('BRG3', 'Alumunium', 'Bahan Baku', '10');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(50) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jk` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `jk`, `password`, `username`) VALUES
('PLG1', 'BUDI', 'sukabirus', 'Laki-Laki', 'budi', 'budi'),
('PLG2', 'Kakaknya Budi', 'sukapura', 'Laki-Laki', 'kakaknyabudi', 'kakaknyabudi'),
('PLG3', 'Adiknya Budi', 'Dayeuhkolot', 'Laki-Laki', 'adiknyabudi', 'adiknyabudi');

-- --------------------------------------------------------

--
-- Table structure for table `pembuat`
--

CREATE TABLE `pembuat` (
  `id_pembuat` varchar(50) NOT NULL,
  `nama_pembuat` varchar(50) NOT NULL,
  `jk_pembuat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembuat`
--

INSERT INTO `pembuat` (`id_pembuat`, `nama_pembuat`, `jk_pembuat`) VALUES
('PMB1', 'Berlian', 'Laki-Laki'),
('PMB2', 'Nopal', 'Laki-Laki'),
('PMB3', 'Jono', 'Laki-Laki');

-- --------------------------------------------------------

--
-- Table structure for table `pembuatan`
--

CREATE TABLE `pembuatan` (
  `id_pembuatan` varchar(50) NOT NULL,
  `nama_pembuat` varchar(50) NOT NULL,
  `id_pesawat` varchar(50) NOT NULL,
  `lama_pembuatan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembuatan`
--

INSERT INTO `pembuatan` (`id_pembuatan`, `nama_pembuat`, `id_pesawat`, `lama_pembuatan`) VALUES
('PEM1', 'PMB2', 'PSW1', '100 hari'),
('PEM2', 'PMB3', 'PSW3', '120 hari'),
('PEM3', 'PMB3', 'PSW2', '150 hari');

-- --------------------------------------------------------

--
-- Table structure for table `pesawat`
--

CREATE TABLE `pesawat` (
  `id_pesawat` varchar(50) NOT NULL,
  `nama_pesawat` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesawat`
--

INSERT INTO `pesawat` (`id_pesawat`, `nama_pesawat`, `harga`) VALUES
('PSW1', 'Boeing', '120.000.000.000'),
('PSW2', 'Boeing 2.0', '140.000.000.000'),
('PSW3', 'Boeing 3.0', '190.000.000.000');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `nama` varchar(50) NOT NULL,
  `id_supplier` varchar(50) NOT NULL,
  `jk_supplier` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`nama`, `id_supplier`, `jk_supplier`) VALUES
('Berli', 'SUP1', 'Laki-Laki'),
('satrio', 'SUP2', 'Laki-Laki'),
('dedih', 'SUP3', 'Laki-Laki');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(50) NOT NULL,
  `id_pelanggan` varchar(50) NOT NULL,
  `id_admin` varchar(50) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `id_pesawat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_pelanggan`, `id_admin`, `tgl_transaksi`, `id_pesawat`) VALUES
('TRS1', 'PLG1', 'ADM1', '0000-00-00', 'PSW1'),
('TRS1', 'PLG1', 'ADM1', '2015-10-08', 'PSW1'),
('TRS3', 'PLG2', 'ADM2', '2017-08-02', 'PSW2'),
('TRS2', 'PLG2', 'ADM2', '2020-12-07', 'PSW2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pembuat`
--
ALTER TABLE `pembuat`
  ADD PRIMARY KEY (`id_pembuat`);

--
-- Indexes for table `pembuatan`
--
ALTER TABLE `pembuatan`
  ADD PRIMARY KEY (`id_pembuatan`);

--
-- Indexes for table `pesawat`
--
ALTER TABLE `pesawat`
  ADD PRIMARY KEY (`id_pesawat`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`tgl_transaksi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
