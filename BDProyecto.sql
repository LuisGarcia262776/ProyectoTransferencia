
CREATE DATABASE BancoDB;
USE BancoDB;

CREATE TABLE Clientes (
    IdCliente INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(15) NOT NULL,
    ApellidoPaterno VARCHAR(30) NOT NULL,
    ApellidoMaterno VARCHAR(30) NOT NULL,
    Domicilio VARCHAR(80) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    Contrasenia VARCHAR(12) NOT NULL,
    FechaRegistro DATETIME NOT NULL
);

CREATE TABLE Cuentas (
    IdCuenta INT AUTO_INCREMENT PRIMARY KEY,
    NumeroCuenta VARCHAR(20) NOT NULL UNIQUE,
    FechaApertura DATE NOT NULL,
    Saldo DECIMAL(12,2) NOT NULL,
    Estado VARCHAR(20) NOT NULL,
    IdCliente INT NOT NULL,
        FOREIGN KEY (IdCliente) REFERENCES Clientes(IdCliente)
);

CREATE TABLE Operaciones (
    IdOperacion INT AUTO_INCREMENT PRIMARY KEY,
    FechaHora DATETIME NOT NULL,
    TipoOperacion VARCHAR(50) NOT NULL,
    IdCuenta INT NOT NULL,
        FOREIGN KEY (IdCuenta) REFERENCES Cuentas(IdCuenta)
);

CREATE TABLE Transferencias (
    IdOperacion INT PRIMARY KEY,
    Monto DECIMAL(12,2) NOT NULL,
    Concepto VARCHAR(50),
        FOREIGN KEY (IdOperacion) REFERENCES Operaciones(IdOperacion)
);

CREATE TABLE RetirosSinCuenta (
    IdOperacion INT PRIMARY KEY,
    Folio INT NOT NULL UNIQUE,
    ContraseñaRetiro VARCHAR(255) NOT NULL,
    Monto DECIMAL(12,2) NOT NULL,
    FechaHoraSolicitud DATETIME NOT NULL,
    FechaHoraCobro DATETIME,
		FOREIGN KEY (IdOperacion) REFERENCES Operaciones(IdOperacion)
);
