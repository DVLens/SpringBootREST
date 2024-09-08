create database INVENTARIO;
use INVENTARIO;

create table Usuarios(
	ID int not null,
    Username varchar(255) not null,
    Pasword varchar(255) not null,
    FechaCreacion datetime,
    PRIMARY KEY (ID)
);

create table UsuariosLog(
	ID int not null,
    IDUsuario int not null,
    FechaRegistro datetime,
    PRIMARY KEY (ID),
    FOREIGN KEY (IDUsuario) REFERENCES Usuarios(ID)
);

create table Productos(
	ID int not null,
    Nombre varchar(255) not null,
    Codigo varchar(255) not null,
    Descripcion varchar(255),
    Precio decimal not null,
    PRIMARY KEY (ID)
);

create table ProductosHistorial(
	ID int not null,
    IDProducto int not null,
    IDUsuario int not null,
    Nombre varchar(255) not null,
    Codigo varchar(255) not null,
    Descripcion varchar(255),
    Precio decimal not null,
    FechaCreacion datetime not null,
    FechaModificacion datetime not null,
    PRIMARY KEY (ID),
    FOREIGN KEY (IDProducto) REFERENCES Productos(ID),
	FOREIGN KEY (IDUsuario) REFERENCES Usuarios(ID)
);

create table CatalogoMovimientos
(
	ID int not null,
    Nombre varchar(255) not null,
    FechaCreacion datetime not null,
    primary key (ID)
);

create table Sectores
(
	ID int not null,
    Nombre varchar(255) not null,
    Descripcion varchar(255) not null,
    FechaCreacion datetime not null,
    primary key (ID)
);

create table Ubicaciones
(
	ID int not null,
    IDSector int not null,
    Seccion varchar(255) not null,
    CodigoBarras varchar(255) not null,
    FechaCreacion datetime not null,
    primary key (ID),
    foreign key(IDSector) references Sectores(ID)
);

create table Movimientos
(
	ID int not null,
    IDCatalogoMovimiento int not null,
    IDUbicacion int not null,
    IDProducto int not null,
    Cantidad decimal not null,
    Stock decimal not null,
    primary key (ID),
    foreign key(IDCatalogoMovimiento) references CatalogoMovimientos(ID),
    foreign key(IDUbicacion) references Ubicaciones(ID),
    foreign key(IDProducto) references Productos(ID)
);