create database if not exists itv;
use itv;
CREATE TABLE Coche
(
    id int NOT NULL AUTO_INCREMENT,
    marca varchar(45) NOT NULL,
    modelo varchar(45) NOT NULL,
    matricula varchar(45) NOT NULL,
    neutricos varchar(45) NOT NULL,
    PRIMARY KEY (id, matricula),
    INDEX idx_matricula (matricula)  -- Agrega un índice en la columna matricula
);

create table Revision
(
    id int NOT NULL AUTO_INCREMENT,
    fecha date NOT NULL,
    estado boolean NOT NULL,
    primary key (id)
);
CREATE TABLE Identificacion
(
    id_rev int NOT NULL,
    matricula varchar(45) NOT NULL,
    FOREIGN KEY (id_rev) REFERENCES Revision(id),
    FOREIGN KEY (matricula) REFERENCES Coche(matricula),
    PRIMARY KEY (id_rev)
);

create table Exterior
(
    id_rev int NOT NULL,
    neumaticos varchar(45) NOT NULL,
    testLimpiaParabrisas boolean NOT NULL ,
    testLuces boolean NOT NULL ,
    testCinturones boolean NOT NULL ,
    deposito boolean NOT NULL ,
    foreign key (id_rev) references Revision(id),
    primary key (id_rev)
);
create table Interior
(
    id_rev int Not Null ,
    antirobo boolean NOT NULL ,
    antideslizante boolean NOT NULL ,
    frenado boolean NOT NULL,
    foreign key (id_rev) references Revision(id),
    primary key (id_rev)
);
create table Alineacion
(
    id_rev int NOT NULL,
    testFugas boolean NOT NULL ,
    testDireccion boolean NOT NULL ,
    amortiguacion boolean NOT NULL ,
    volante boolean NOT NULL ,
    foreign key (id_rev) references Revision(id),
    primary key (id_rev)
);
create table Emisores
(
    id_rev int NOT NULL,
    indice float NOT NULL ,
    testEmisiones boolean NOT NULL ,
    foreign key (id_rev) references Revision(id),
    primary key (id_rev)
);