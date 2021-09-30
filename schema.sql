
    create table Asociacion (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        direccion varchar(255),
        latitud double not null,
        longitud double not null,
        primary key (id)
    )

    create table CaracteristicaDefinida (
        tipo varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        valor varchar(255),
        publicacionMascotaEnAdopcionId bigint,
        publicacionIntencionAdopcionId bigint,
        mascota_id bigint,
        primary key (id)
    )

    create table Mascota (
        id bigint generated by default as identity (start with 1),
        apodo varchar(255),
        descripcionFisica varchar(255),
        edad integer not null,
        id_mascota varchar(255),
        nombre varchar(255),
        sexo integer,
        tamanio integer,
        tipoAnimal integer,
        primary key (id)
    )

    create table Mascota_fotos (
        Mascota_id bigint not null,
        fotos varchar(255)
    )

    create table PublicacionIntencionDeAdopcion (
        id bigint generated by default as identity (start with 1),
        linkDeBaja varchar(255),
        sexoMascota integer,
        tamanioMascota integer,
        tipoAnimal integer,
        primary key (id)
    )

    create table PublicacionMascotaEnAdopcion (
        id bigint generated by default as identity (start with 1),
        numeroPublicacion varchar(255),
        mascotaId bigint,
        primary key (id)
    )

    create table Voluntario (
        id bigint generated by default as identity (start with 1),
        Asociacion_id bigint,
        primary key (id)
    )

    create table contacto (
        id bigint generated by default as identity (start with 1),
        apellido varchar(255),
        email varchar(255),
        nombre varchar(255),
        telefono integer,
        rescatistaId bigint,
        duenioId bigint,
        primary key (id)
    )

    create table duenio (
        id bigint generated by default as identity (start with 1),
        apellido varchar(255),
        documento double,
        fecha_nacimiento varbinary(255),
        nombre varchar(255),
        tipo_documento integer,
        contactoPrincipal_id bigint,
        primary key (id)
    )

    create table rescatista (
        id bigint generated by default as identity (start with 1),
        apellido varchar(255),
        direccion varchar(255),
        fecha_nacimiento varbinary(255),
        nombre varchar(255),
        tipo_documento integer,
        contactoPrincipal_id bigint,
        primary key (id)
    )

    alter table CaracteristicaDefinida 
        add constraint FK_kajc02geyf6ce6w83dq0ms3r7 
        foreign key (publicacionMascotaEnAdopcionId) 
        references PublicacionMascotaEnAdopcion

    alter table CaracteristicaDefinida 
        add constraint FK_e0a796badblcnbu37tvtud2mk 
        foreign key (publicacionIntencionAdopcionId) 
        references PublicacionIntencionDeAdopcion

    alter table CaracteristicaDefinida 
        add constraint FK_adadgmnr0v7y7msjq0kgajadb 
        foreign key (mascota_id) 
        references Mascota

    alter table Mascota_fotos 
        add constraint FK_dclevnore3slbildn3hia9nlo 
        foreign key (Mascota_id) 
        references Mascota

    alter table PublicacionMascotaEnAdopcion 
        add constraint FK_tm8ormb83asm4bl8voo6fcs4s 
        foreign key (mascotaId) 
        references Mascota

    alter table Voluntario 
        add constraint FK_elh1fu4oewfjf4mdjbo252cce 
        foreign key (Asociacion_id) 
        references Asociacion

    alter table contacto 
        add constraint FK_odj5b4yqkjek8cuk0pbcs3hhv 
        foreign key (rescatistaId) 
        references rescatista

    alter table contacto 
        add constraint FK_ruava120cqs11gxul97an2g5c 
        foreign key (duenioId) 
        references duenio

    alter table duenio 
        add constraint FK_eulo1elbe5cvp5dvf9pk6vhkf 
        foreign key (contactoPrincipal_id) 
        references contacto

    alter table rescatista 
        add constraint FK_skfoy7m7pwb33ve2olfped0lq 
        foreign key (contactoPrincipal_id) 
        references contacto
