const fs = require('fs');

const BCRYPT_HASH = '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK'; // password123

let sql = `
TRUNCATE TABLE alerts CASCADE;
TRUNCATE TABLE resource_assignments CASCADE;
TRUNCATE TABLE messages CASCADE;
TRUNCATE TABLE chats CASCADE;
TRUNCATE TABLE events CASCADE;
TRUNCATE TABLE user_achievements CASCADE;
TRUNCATE TABLE achievements CASCADE;
TRUNCATE TABLE psychologist_patients CASCADE;
TRUNCATE TABLE resources CASCADE;
TRUNCATE TABLE daily_logs CASCADE;
TRUNCATE TABLE users CASCADE;
TRUNCATE TABLE roles CASCADE;

INSERT INTO roles (id, name) VALUES (1, 'PACIENTE');
INSERT INTO roles (id, name) VALUES (2, 'PSICOLOGO');

`;

// PSYCHOLOGISTS
const psychs = [
    { id: 101, name: 'Roberto Mendoza', age: 45, email: 'roberto@clinicamendoza.com', specialty: 'Psicólogo Clínico', clinic: 'Clínica Bienestar', pic: 'https://randomuser.me/api/portraits/men/32.jpg' },
    { id: 102, name: 'Ana Silva', age: 38, email: 'ana.silva@menteactiva.pe', specialty: 'Terapia Cognitivo-Conductual', clinic: 'Centro Mente Activa', pic: 'https://randomuser.me/api/portraits/women/44.jpg' },
    { id: 103, name: 'Carlos Ruiz', age: 50, email: 'cruiz@psicologos.org', specialty: 'Terapia de Pareja y Familia', clinic: 'Consultorio Ruiz', pic: 'https://randomuser.me/api/portraits/men/15.jpg' },
    { id: 104, name: 'Elena Vargas', age: 41, email: 'elena.vargas@serenidad.com', specialty: 'Neuropsicología', clinic: 'Serenidad Mental Center', pic: 'https://randomuser.me/api/portraits/women/68.jpg' },
    { id: 105, name: 'Javier Gómez', age: 35, email: 'jgomez@terapiaya.com', specialty: 'Psicología Educativa', clinic: 'Centro de Apoyo Joven', pic: 'https://randomuser.me/api/portraits/men/55.jpg' }
];

sql += `-- Psicólogos\n`;
psychs.forEach(p => {
    sql += `INSERT INTO users (id, name, age, email, password_hash, role_id, specialty, clinic_name, created_at) VALUES (${p.id}, '${p.name}', ${p.age}, '${p.email}', '${BCRYPT_HASH}', 2, '${p.specialty}', '${p.clinic}', NOW());\n`;
});
sql += `\n`;

// PATIENTS
const patients = [
    { id: 1, name: 'Mateo Díaz', age: 22, email: 'mateo@gmail.com', pt: 45, dg: 60, streak: 5, points: 120, pic: 'https://randomuser.me/api/portraits/men/1.jpg' },
    { id: 2, name: 'Sofía Castro', age: 25, email: 'sofia@gmail.com', pt: 30, dg: 45, streak: 12, points: 350, pic: 'https://randomuser.me/api/portraits/women/2.jpg' },
    { id: 3, name: 'Diego López', age: 19, email: 'diego@gmail.com', pt: 60, dg: 120, streak: 2, points: 40, pic: 'https://randomuser.me/api/portraits/men/3.jpg' },
    { id: 4, name: 'Valentina Flores', age: 28, email: 'valentina@gmail.com', pt: 40, dg: 60, streak: 8, points: 200, pic: 'https://randomuser.me/api/portraits/women/4.jpg' },
    { id: 5, name: 'Joaquín Ríos', age: 31, email: 'joaquin@gmail.com', pt: 45, dg: 90, streak: 0, points: 15, pic: 'https://randomuser.me/api/portraits/men/5.jpg' },
    { id: 6, name: 'Camila Rojas', age: 21, email: 'camila@gmail.com', pt: 30, dg: 60, streak: 21, points: 600, pic: 'https://randomuser.me/api/portraits/women/6.jpg' },
    { id: 7, name: 'Sebastián Mora', age: 24, email: 'sebastian@gmail.com', pt: 60, dg: 120, streak: 1, points: 10, pic: 'https://randomuser.me/api/portraits/men/7.jpg' },
    { id: 8, name: 'Lucía Fernández', age: 27, email: 'lucia@gmail.com', pt: 40, dg: 50, streak: 4, points: 90, pic: 'https://randomuser.me/api/portraits/women/8.jpg' },
    { id: 9, name: 'Martín Sánchez', age: 20, email: 'martin@gmail.com', pt: 45, dg: 90, streak: 7, points: 180, pic: 'https://randomuser.me/api/portraits/men/9.jpg' },
    { id: 10, name: 'Isabella Paredes', age: 23, email: 'isabella@gmail.com', pt: 30, dg: 60, streak: 15, points: 450, pic: 'https://randomuser.me/api/portraits/women/10.jpg' }
];

sql += `-- Pacientes\n`;
patients.forEach(p => {
    sql += `INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (${p.id}, '${p.name}', ${p.age}, '${p.email}', '${BCRYPT_HASH}', 1, ${p.pt}, ${p.dg}, ${p.streak}, ${p.points}, CURRENT_DATE, NOW());\n`;
});
sql += `\n`;

// FIX SEQUENCES
sql += `-- Arreglar secuencias de IDs\n`;
sql += `SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));\n`;
sql += `SELECT setval('roles_id_seq', (SELECT MAX(id) FROM roles));\n\n`;

// RELATIONSHIPS
sql += `-- Relaciones Psicólogo - Paciente\n`;
// Dr. Roberto Mendoza (101) -> Mateo, Sofia, Diego
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (1, 101, 1, NOW() - INTERVAL '30 days', 'ACCEPTED', 'Me gustaría iniciar terapia');\n`;
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (2, 101, 2, NOW() - INTERVAL '15 days', 'ACCEPTED', 'Hola doctor');\n`;
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (3, 101, 3, NOW() - INTERVAL '2 days', 'PENDING', 'Necesito ayuda urgente');\n`;

// Dra. Ana Silva (102) -> Valentina, Joaquin
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (4, 102, 4, NOW() - INTERVAL '40 days', 'ACCEPTED', 'Recomendación de un amigo');\n`;
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (5, 102, 5, NOW() - INTERVAL '10 days', 'ACCEPTED', 'Quiero trabajar ansiedad');\n`;

// Dr. Carlos Ruiz (103) -> Camila, Sebastian
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (6, 103, 6, NOW() - INTERVAL '60 days', 'ACCEPTED', 'Hola');\n`;
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (7, 103, 7, NOW() - INTERVAL '5 days', 'PENDING', 'Busco terapia');\n`;

// Dra. Elena Vargas (104) -> Lucia, Martin
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (8, 104, 8, NOW() - INTERVAL '20 days', 'ACCEPTED', 'Hola doctora');\n`;
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (9, 104, 9, NOW() - INTERVAL '1 day', 'ACCEPTED', 'Problemas en el trabajo');\n`;

// Dr. Javier Gómez (105) -> Isabella
sql += `INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (10, 105, 10, NOW() - INTERVAL '50 days', 'ACCEPTED', 'Busco orientación');\n`;

sql += `SELECT setval('psychologist_patients_id_seq', 10);\n\n`;

// DAILY LOGS
sql += `-- Registros Diarios (Últimos 7 días para cada paciente)\n`;
let logId = 1;
patients.forEach(p => {
    for (let day = 6; day >= 0; day--) {
        // Randomize usage to make graphs interesting
        let minsSocial = Math.floor(Math.random() * 180) + 30; // 30 - 210
        let sleep = Math.floor(Math.random() * 5) + 4; // 4 - 8 hours
        let nightUse = Math.floor(Math.random() * 60); // 0 - 60 mins
        
        let active = Math.floor(Math.random() * 60) + 10;
        let breakM = Math.floor(Math.random() * 30);
        
        let typeEmotion = ['HAPPY', 'SAD', 'ANXIOUS', 'CALM', 'NONE'][Math.floor(Math.random() * 5)];
        
        sql += `INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (${logId++}, ${p.id}, CURRENT_DATE - INTERVAL '${day} days', ${minsSocial}, ${sleep}, ${nightUse}, ${active}, ${breakM}, '${typeEmotion}', 'Día ${day === 0 ? "hoy" : "hace " + day + " días"}', ${p.dg}, NOW() - INTERVAL '${day} days');\n`;
    }
});
sql += `SELECT setval('daily_logs_id_seq', ${logId});\n\n`; 

// ALERTS
sql += `-- Alertas (Alerts)\n`;
sql += `INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (1, 101, 1, 'TIEMPO_EXCEDIDO', 'Mateo ha excedido su meta de pantalla hoy.', false, NOW());\n`;
sql += `INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (2, 101, 2, 'FALTA_DE_SUEÑO', 'Sofía durmió menos de 5 horas.', false, NOW() - INTERVAL '1 days');\n`;
sql += `INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (3, 102, 4, 'ESTRES_ELEVADO', 'Valentina registró ansiedad hoy.', false, NOW());\n`;
sql += `INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (4, 103, 6, 'USO_NOCTURNO', 'Camila usó redes de madrugada.', true, NOW() - INTERVAL '2 days');\n`;
sql += `INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (5, 104, 8, 'RACHA_PERDIDA', 'Lucía rompió su racha de registros.', false, NOW());\n`;

sql += `SELECT setval('alerts_id_seq', 5);\n\n`;

// ACHIEVEMENTS
sql += `-- Logros (Achievements)\n`;
sql += `INSERT INTO achievements (id, nombre, descripcion, points_required, icon_url) VALUES (1, 'Primer Paso', 'Completaste tu primer registro diario', 10, 'emoji_events');\n`;
sql += `INSERT INTO achievements (id, nombre, descripcion, points_required, icon_url) VALUES (2, 'Constancia', 'Mantuviste una racha de 7 días', 100, 'star');\n`;
sql += `INSERT INTO achievements (id, nombre, descripcion, points_required, icon_url) VALUES (3, 'Maestro Zen', 'Alcanzaste 500 puntos en total', 500, 'self_improvement');\n`;
sql += `SELECT setval('achievements_id_seq', 3);\n\n`;

// RESOURCES
sql += `-- Recursos (Resources)\n`;
sql += `INSERT INTO resources (id, title, description, url, category, uploaded_by, created_at) VALUES (1, 'Meditación Guiada para Ansiedad', '10 minutos de relajación', 'https://www.youtube.com/watch?v=1', 'MEDITATION', 101, NOW());\n`;
sql += `INSERT INTO resources (id, title, description, url, category, uploaded_by, created_at) VALUES (2, 'Música Relajante para Dormir', 'Frecuencias curativas', 'https://www.youtube.com/watch?v=2', 'MUSIC', 102, NOW());\n`;
sql += `INSERT INTO resources (id, title, description, url, category, uploaded_by, created_at) VALUES (3, 'Guía de Hábitos Saludables', 'Documento para mejorar tu día a día', 'https://example.com/doc', 'ADVISORY_DOC', 104, NOW());\n`;
sql += `SELECT setval('resources_id_seq', 3);\n\n`;

fs.writeFileSync('C:\\Users\\kinoz\\Downloads\\backend 1\\TrabajoFinal\\src\\main\\resources\\data.sql', sql);
console.log('import.sql generated successfully.');
