
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

-- Psicólogos
INSERT INTO users (id, name, age, email, password_hash, role_id, specialty, clinic_name, created_at) VALUES (101, 'Roberto Mendoza', 45, 'roberto@clinicamendoza.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 2, 'Psicólogo Clínico', 'Clínica Bienestar', NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, specialty, clinic_name, created_at) VALUES (102, 'Ana Silva', 38, 'ana.silva@menteactiva.pe', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 2, 'Terapia Cognitivo-Conductual', 'Centro Mente Activa', NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, specialty, clinic_name, created_at) VALUES (103, 'Carlos Ruiz', 50, 'cruiz@psicologos.org', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 2, 'Terapia de Pareja y Familia', 'Consultorio Ruiz', NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, specialty, clinic_name, created_at) VALUES (104, 'Elena Vargas', 41, 'elena.vargas@serenidad.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 2, 'Neuropsicología', 'Serenidad Mental Center', NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, specialty, clinic_name, created_at) VALUES (105, 'Javier Gómez', 35, 'jgomez@terapiaya.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 2, 'Psicología Educativa', 'Centro de Apoyo Joven', NOW());

-- Pacientes
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (1, 'Mateo Díaz', 22, 'mateo@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 45, 60, 5, 120, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (2, 'Sofía Castro', 25, 'sofia@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 30, 45, 12, 350, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (3, 'Diego López', 19, 'diego@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 60, 120, 2, 40, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (4, 'Valentina Flores', 28, 'valentina@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 40, 60, 8, 200, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (5, 'Joaquín Ríos', 31, 'joaquin@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 45, 90, 0, 15, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (6, 'Camila Rojas', 21, 'camila@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 30, 60, 21, 600, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (7, 'Sebastián Mora', 24, 'sebastian@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 60, 120, 1, 10, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (8, 'Lucía Fernández', 27, 'lucia@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 40, 50, 4, 90, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (9, 'Martín Sánchez', 20, 'martin@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 45, 90, 7, 180, CURRENT_DATE, NOW());
INSERT INTO users (id, name, age, email, password_hash, role_id, pause_threshold_minutes, daily_goal_minutes, current_streak, total_points, last_log_date, created_at) VALUES (10, 'Isabella Paredes', 23, 'isabella@gmail.com', '$2a$10$0p7tC6hD.yFi3bSE0SOk/.VtzbaOoYqsUiaIYeUI/B2Tr.KEzbREK', 1, 30, 60, 15, 450, CURRENT_DATE, NOW());

-- Arreglar secuencias de IDs
SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));
SELECT setval('roles_id_seq', (SELECT MAX(id) FROM roles));

-- Relaciones Psicólogo - Paciente
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (1, 101, 1, NOW() - INTERVAL '30 days', 'ACCEPTED', 'Me gustaría iniciar terapia');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (2, 101, 2, NOW() - INTERVAL '15 days', 'ACCEPTED', 'Hola doctor');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (3, 101, 3, NOW() - INTERVAL '2 days', 'PENDING', 'Necesito ayuda urgente');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (4, 102, 4, NOW() - INTERVAL '40 days', 'ACCEPTED', 'Recomendación de un amigo');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (5, 102, 5, NOW() - INTERVAL '10 days', 'ACCEPTED', 'Quiero trabajar ansiedad');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (6, 103, 6, NOW() - INTERVAL '60 days', 'ACCEPTED', 'Hola');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (7, 103, 7, NOW() - INTERVAL '5 days', 'PENDING', 'Busco terapia');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (8, 104, 8, NOW() - INTERVAL '20 days', 'ACCEPTED', 'Hola doctora');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (9, 104, 9, NOW() - INTERVAL '1 day', 'ACCEPTED', 'Problemas en el trabajo');
INSERT INTO psychologist_patients (id, psicologo_id, paciente_id, fecha_asignacion, status, mensaje_solicitud) VALUES (10, 105, 10, NOW() - INTERVAL '50 days', 'ACCEPTED', 'Busco orientación');
SELECT setval('psychologist_patients_id_seq', 10);

-- Registros Diarios (Últimos 7 días para cada paciente)
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (1, 1, CURRENT_DATE - INTERVAL '6 days', 62, 6, 13, 13, 22, 'ANXIOUS', 'Día hace 6 días', 60, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (2, 1, CURRENT_DATE - INTERVAL '5 days', 105, 5, 5, 61, 12, 'ANXIOUS', 'Día hace 5 días', 60, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (3, 1, CURRENT_DATE - INTERVAL '4 days', 102, 4, 43, 40, 14, 'NONE', 'Día hace 4 días', 60, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (4, 1, CURRENT_DATE - INTERVAL '3 days', 131, 8, 0, 56, 15, 'CALM', 'Día hace 3 días', 60, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (5, 1, CURRENT_DATE - INTERVAL '2 days', 126, 7, 15, 34, 24, 'NONE', 'Día hace 2 días', 60, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (6, 1, CURRENT_DATE - INTERVAL '1 days', 103, 7, 18, 29, 18, 'NONE', 'Día hace 1 días', 60, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (7, 1, CURRENT_DATE - INTERVAL '0 days', 175, 4, 16, 59, 8, 'HAPPY', 'Día hoy', 60, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (8, 2, CURRENT_DATE - INTERVAL '6 days', 39, 6, 21, 51, 25, 'NONE', 'Día hace 6 días', 45, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (9, 2, CURRENT_DATE - INTERVAL '5 days', 167, 6, 56, 35, 2, 'SAD', 'Día hace 5 días', 45, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (10, 2, CURRENT_DATE - INTERVAL '4 days', 100, 5, 56, 40, 18, 'NONE', 'Día hace 4 días', 45, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (11, 2, CURRENT_DATE - INTERVAL '3 days', 202, 4, 50, 67, 0, 'ANXIOUS', 'Día hace 3 días', 45, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (12, 2, CURRENT_DATE - INTERVAL '2 days', 190, 8, 5, 49, 3, 'CALM', 'Día hace 2 días', 45, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (13, 2, CURRENT_DATE - INTERVAL '1 days', 124, 6, 23, 24, 7, 'NONE', 'Día hace 1 días', 45, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (14, 2, CURRENT_DATE - INTERVAL '0 days', 184, 7, 52, 43, 20, 'CALM', 'Día hoy', 45, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (15, 3, CURRENT_DATE - INTERVAL '6 days', 157, 8, 12, 45, 25, 'CALM', 'Día hace 6 días', 120, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (16, 3, CURRENT_DATE - INTERVAL '5 days', 33, 4, 57, 53, 16, 'NONE', 'Día hace 5 días', 120, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (17, 3, CURRENT_DATE - INTERVAL '4 days', 149, 6, 44, 44, 3, 'ANXIOUS', 'Día hace 4 días', 120, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (18, 3, CURRENT_DATE - INTERVAL '3 days', 91, 7, 22, 46, 28, 'ANXIOUS', 'Día hace 3 días', 120, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (19, 3, CURRENT_DATE - INTERVAL '2 days', 190, 6, 56, 29, 10, 'NONE', 'Día hace 2 días', 120, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (20, 3, CURRENT_DATE - INTERVAL '1 days', 86, 5, 1, 39, 3, 'SAD', 'Día hace 1 días', 120, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (21, 3, CURRENT_DATE - INTERVAL '0 days', 191, 7, 54, 46, 10, 'NONE', 'Día hoy', 120, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (22, 4, CURRENT_DATE - INTERVAL '6 days', 66, 7, 40, 40, 17, 'ANXIOUS', 'Día hace 6 días', 60, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (23, 4, CURRENT_DATE - INTERVAL '5 days', 65, 6, 49, 60, 5, 'HAPPY', 'Día hace 5 días', 60, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (24, 4, CURRENT_DATE - INTERVAL '4 days', 45, 4, 18, 65, 6, 'ANXIOUS', 'Día hace 4 días', 60, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (25, 4, CURRENT_DATE - INTERVAL '3 days', 149, 5, 21, 24, 17, 'SAD', 'Día hace 3 días', 60, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (26, 4, CURRENT_DATE - INTERVAL '2 days', 106, 6, 7, 66, 21, 'NONE', 'Día hace 2 días', 60, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (27, 4, CURRENT_DATE - INTERVAL '1 days', 148, 4, 20, 50, 3, 'NONE', 'Día hace 1 días', 60, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (28, 4, CURRENT_DATE - INTERVAL '0 days', 35, 6, 50, 25, 15, 'HAPPY', 'Día hoy', 60, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (29, 5, CURRENT_DATE - INTERVAL '6 days', 98, 5, 34, 63, 25, 'HAPPY', 'Día hace 6 días', 90, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (30, 5, CURRENT_DATE - INTERVAL '5 days', 161, 8, 53, 39, 18, 'CALM', 'Día hace 5 días', 90, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (31, 5, CURRENT_DATE - INTERVAL '4 days', 173, 8, 48, 65, 22, 'ANXIOUS', 'Día hace 4 días', 90, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (32, 5, CURRENT_DATE - INTERVAL '3 days', 61, 7, 48, 54, 0, 'SAD', 'Día hace 3 días', 90, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (33, 5, CURRENT_DATE - INTERVAL '2 days', 135, 8, 25, 37, 12, 'ANXIOUS', 'Día hace 2 días', 90, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (34, 5, CURRENT_DATE - INTERVAL '1 days', 158, 5, 14, 60, 27, 'NONE', 'Día hace 1 días', 90, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (35, 5, CURRENT_DATE - INTERVAL '0 days', 189, 7, 54, 30, 10, 'ANXIOUS', 'Día hoy', 90, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (36, 6, CURRENT_DATE - INTERVAL '6 days', 166, 8, 35, 62, 17, 'HAPPY', 'Día hace 6 días', 60, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (37, 6, CURRENT_DATE - INTERVAL '5 days', 189, 7, 56, 56, 5, 'CALM', 'Día hace 5 días', 60, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (38, 6, CURRENT_DATE - INTERVAL '4 days', 131, 8, 34, 27, 0, 'HAPPY', 'Día hace 4 días', 60, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (39, 6, CURRENT_DATE - INTERVAL '3 days', 204, 4, 18, 49, 2, 'SAD', 'Día hace 3 días', 60, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (40, 6, CURRENT_DATE - INTERVAL '2 days', 74, 7, 3, 56, 16, 'HAPPY', 'Día hace 2 días', 60, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (41, 6, CURRENT_DATE - INTERVAL '1 days', 134, 7, 19, 48, 21, 'HAPPY', 'Día hace 1 días', 60, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (42, 6, CURRENT_DATE - INTERVAL '0 days', 190, 8, 14, 65, 10, 'ANXIOUS', 'Día hoy', 60, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (43, 7, CURRENT_DATE - INTERVAL '6 days', 89, 6, 33, 34, 8, 'ANXIOUS', 'Día hace 6 días', 120, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (44, 7, CURRENT_DATE - INTERVAL '5 days', 199, 6, 56, 18, 19, 'HAPPY', 'Día hace 5 días', 120, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (45, 7, CURRENT_DATE - INTERVAL '4 days', 53, 4, 16, 51, 13, 'SAD', 'Día hace 4 días', 120, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (46, 7, CURRENT_DATE - INTERVAL '3 days', 119, 7, 29, 44, 14, 'ANXIOUS', 'Día hace 3 días', 120, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (47, 7, CURRENT_DATE - INTERVAL '2 days', 196, 7, 27, 67, 22, 'SAD', 'Día hace 2 días', 120, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (48, 7, CURRENT_DATE - INTERVAL '1 days', 32, 8, 43, 45, 27, 'HAPPY', 'Día hace 1 días', 120, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (49, 7, CURRENT_DATE - INTERVAL '0 days', 88, 4, 21, 52, 4, 'SAD', 'Día hoy', 120, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (50, 8, CURRENT_DATE - INTERVAL '6 days', 127, 5, 0, 42, 27, 'NONE', 'Día hace 6 días', 50, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (51, 8, CURRENT_DATE - INTERVAL '5 days', 52, 6, 20, 62, 22, 'HAPPY', 'Día hace 5 días', 50, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (52, 8, CURRENT_DATE - INTERVAL '4 days', 44, 7, 53, 24, 9, 'ANXIOUS', 'Día hace 4 días', 50, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (53, 8, CURRENT_DATE - INTERVAL '3 days', 47, 6, 29, 41, 2, 'SAD', 'Día hace 3 días', 50, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (54, 8, CURRENT_DATE - INTERVAL '2 days', 36, 5, 11, 20, 22, 'ANXIOUS', 'Día hace 2 días', 50, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (55, 8, CURRENT_DATE - INTERVAL '1 days', 30, 4, 55, 27, 3, 'SAD', 'Día hace 1 días', 50, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (56, 8, CURRENT_DATE - INTERVAL '0 days', 53, 7, 8, 14, 25, 'ANXIOUS', 'Día hoy', 50, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (57, 9, CURRENT_DATE - INTERVAL '6 days', 165, 8, 28, 43, 1, 'SAD', 'Día hace 6 días', 90, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (58, 9, CURRENT_DATE - INTERVAL '5 days', 71, 6, 47, 37, 24, 'NONE', 'Día hace 5 días', 90, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (59, 9, CURRENT_DATE - INTERVAL '4 days', 95, 6, 47, 17, 3, 'ANXIOUS', 'Día hace 4 días', 90, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (60, 9, CURRENT_DATE - INTERVAL '3 days', 45, 8, 59, 59, 4, 'CALM', 'Día hace 3 días', 90, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (61, 9, CURRENT_DATE - INTERVAL '2 days', 53, 7, 9, 55, 22, 'NONE', 'Día hace 2 días', 90, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (62, 9, CURRENT_DATE - INTERVAL '1 days', 123, 7, 23, 36, 21, 'ANXIOUS', 'Día hace 1 días', 90, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (63, 9, CURRENT_DATE - INTERVAL '0 days', 76, 4, 0, 51, 16, 'SAD', 'Día hoy', 90, NOW() - INTERVAL '0 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (64, 10, CURRENT_DATE - INTERVAL '6 days', 95, 4, 24, 40, 15, 'SAD', 'Día hace 6 días', 60, NOW() - INTERVAL '6 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (65, 10, CURRENT_DATE - INTERVAL '5 days', 58, 4, 55, 11, 19, 'ANXIOUS', 'Día hace 5 días', 60, NOW() - INTERVAL '5 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (66, 10, CURRENT_DATE - INTERVAL '4 days', 71, 4, 56, 16, 22, 'HAPPY', 'Día hace 4 días', 60, NOW() - INTERVAL '4 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (67, 10, CURRENT_DATE - INTERVAL '3 days', 75, 5, 18, 49, 17, 'NONE', 'Día hace 3 días', 60, NOW() - INTERVAL '3 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (68, 10, CURRENT_DATE - INTERVAL '2 days', 90, 7, 2, 29, 20, 'SAD', 'Día hace 2 días', 60, NOW() - INTERVAL '2 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (69, 10, CURRENT_DATE - INTERVAL '1 days', 133, 7, 38, 22, 11, 'SAD', 'Día hace 1 días', 60, NOW() - INTERVAL '1 days');
INSERT INTO daily_logs (id, usuario_id, fecha_registro, minutos_redes_sociales, horas_sueno, minutos_uso_nocturno, minutos_activos, minutos_descanso, tipo_emocion, notas_emocion, meta_diaria_redes_sociales, ultima_actualizacion) 
        VALUES (70, 10, CURRENT_DATE - INTERVAL '0 days', 57, 7, 26, 15, 1, 'ANXIOUS', 'Día hoy', 60, NOW() - INTERVAL '0 days');
SELECT setval('daily_logs_id_seq', 71);

-- Alertas (Alerts)
INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (1, 101, 1, 'TIEMPO_EXCEDIDO', 'Mateo ha excedido su meta de pantalla hoy.', false, NOW());
INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (2, 101, 2, 'FALTA_DE_SUEÑO', 'Sofía durmió menos de 5 horas.', false, NOW() - INTERVAL '1 days');
INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (3, 102, 4, 'ESTRES_ELEVADO', 'Valentina registró ansiedad hoy.', false, NOW());
INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (4, 103, 6, 'USO_NOCTURNO', 'Camila usó redes de madrugada.', true, NOW() - INTERVAL '2 days');
INSERT INTO alerts (id, recipient_id, trigger_user_id, tipo, mensaje, is_read, created_at) VALUES (5, 104, 8, 'RACHA_PERDIDA', 'Lucía rompió su racha de registros.', false, NOW());
SELECT setval('alerts_id_seq', 5);

-- Logros (Achievements)
INSERT INTO achievements (id, nombre, descripcion, points_required, icon_url) VALUES (1, 'Primer Paso', 'Completaste tu primer registro diario', 10, 'emoji_events');
INSERT INTO achievements (id, nombre, descripcion, points_required, icon_url) VALUES (2, 'Constancia', 'Mantuviste una racha de 7 días', 100, 'star');
INSERT INTO achievements (id, nombre, descripcion, points_required, icon_url) VALUES (3, 'Maestro Zen', 'Alcanzaste 500 puntos en total', 500, 'self_improvement');
SELECT setval('achievements_id_seq', 3);

-- Recursos (Resources)
INSERT INTO resources (id, title, description, url, category, uploaded_by, created_at) VALUES (1, 'Meditación Guiada para Ansiedad', '10 minutos de relajación', 'https://www.youtube.com/watch?v=1', 'MEDITATION', 101, NOW());
INSERT INTO resources (id, title, description, url, category, uploaded_by, created_at) VALUES (2, 'Música Relajante para Dormir', 'Frecuencias curativas', 'https://www.youtube.com/watch?v=2', 'MUSIC', 102, NOW());
INSERT INTO resources (id, title, description, url, category, uploaded_by, created_at) VALUES (3, 'Guía de Hábitos Saludables', 'Documento para mejorar tu día a día', 'https://example.com/doc', 'ADVISORY_DOC', 104, NOW());
SELECT setval('resources_id_seq', 3);

