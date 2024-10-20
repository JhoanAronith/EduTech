USE Edutech;

CREATE TABLE Alumno (
    id_alumno INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(100),
    telefono VARCHAR(15),
    direccion VARCHAR(255)
);

ALTER TABLE Alumno
ADD contrasena VARCHAR(255),
ADD CONSTRAINT unique_email UNIQUE (email);

CREATE TABLE Pago (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    fecha_pago DATE,
    monto DECIMAL(10, 2),
    metodo_pago VARCHAR(50),
    alumno_id INT,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno)
);

CREATE TABLE Administrador (
    id_administrador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE Categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

CREATE TABLE Curso (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    categoria_id INT NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    administrador_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id_categoria),
    FOREIGN KEY (administrador_id) REFERENCES Administrador(id_administrador)
);

CREATE TABLE Examen (
    id_examen INT AUTO_INCREMENT PRIMARY KEY,
    curso_id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha DATE NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES Curso(id_curso)
);

CREATE TABLE RegistroCurso (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    alumno_id INT NOT NULL,
    curso_id INT NOT NULL,
    fecha_inscripcion DATE NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno),
    FOREIGN KEY (curso_id) REFERENCES Curso(id_curso)
);

CREATE TABLE ExamenAlumno (
    id_examen_alumno INT AUTO_INCREMENT PRIMARY KEY,
    examen_id INT NOT NULL,
    alumno_id INT NOT NULL,
    nota DECIMAL(5, 2),
    FOREIGN KEY (examen_id) REFERENCES Examen(id_examen),
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno)
);

CREATE TABLE Certificacion (
    id_certificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    alumno_id INT NOT NULL,
    curso_id INT NOT NULL,
    fecha_emision DATE NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno),
    FOREIGN KEY (curso_id) REFERENCES Curso(id_curso)
);
