--BD name edutech2

USE edutech2;

-- Tabla de Alumno
CREATE TABLE Alumno (
    id_alumno INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    contrasena VARCHAR(255)
);

-- Tabla de Administrador
CREATE TABLE Administrador (
    id_administrador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- Tabla de Certificacion
CREATE TABLE Certificacion (
    id_certificacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- Tabla de Curso
CREATE TABLE Curso (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,     
    titulo VARCHAR(255) NOT NULL,                
    duracion INT NOT NULL,                        
    descripcion TEXT,                             
    categoria VARCHAR(100),                       
    nivel VARCHAR(50),                           
    certificacion_id INT,                        -- Clave foránea a Certificacion
    FOREIGN KEY (certificacion_id) REFERENCES Certificacion(id_certificacion)
);

-- Tabla de Modulo
CREATE TABLE Modulo (
    id_modulo INT AUTO_INCREMENT PRIMARY KEY, 
    titulo VARCHAR(255) NOT NULL,            
    archivoZIP VARCHAR(255),                 
    videoLink VARCHAR(255),                   
    curso_id INT NOT NULL,                   
    FOREIGN KEY (curso_id) REFERENCES Curso(id_curso) ON DELETE CASCADE
);

-- Tabla de Examen
CREATE TABLE Examen (
    id_examen INT AUTO_INCREMENT PRIMARY KEY,
    curso_id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (curso_id) REFERENCES Curso(id_curso) ON DELETE CASCADE
);

-- Tabla de RegistroCurso
CREATE TABLE RegistroCurso (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    alumno_id INT NOT NULL,
    curso_id INT NOT NULL,
    fecha_inscripcion DATE NOT NULL,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno) ON DELETE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES Curso(id_curso) ON DELETE CASCADE
);

-- Tabla de ExamenAlumno
CREATE TABLE ExamenAlumno (
    id_examen_alumno INT AUTO_INCREMENT PRIMARY KEY,
    examen_id INT NOT NULL,
    alumno_id INT NOT NULL,
    nota DECIMAL(5, 2),
    FOREIGN KEY (examen_id) REFERENCES Examen(id_examen) ON DELETE CASCADE,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno) ON DELETE CASCADE
);

-- Tabla de Pago
CREATE TABLE Pago (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(10, 2),
    metodo_pago VARCHAR(50),
    alumno_id INT,
    FOREIGN KEY (alumno_id) REFERENCES Alumno(id_alumno)
);

