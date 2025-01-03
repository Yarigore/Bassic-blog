-- Inserción de roles
INSERT INTO role (id, role_name) VALUES (1, 'ADMIN');
INSERT INTO role (id, role_name) VALUES (2, 'USER');

-- Inserción de usuarios
INSERT INTO "user" (id, name, password, role_id) VALUES (1, 'admin', 'password_admin', 1);
INSERT INTO "user" (id, name, password, role_id) VALUES (2, 'johndoe', 'password_user', 2);

-- Inserción de categorías
INSERT INTO category (id, name) VALUES (1, 'Technology');
INSERT INTO category (id, name) VALUES (2, 'Lifestyle');

-- Inserción de etiquetas (tags)
INSERT INTO tag (id, name) VALUES (1, 'Java');
INSERT INTO tag (id, name) VALUES (2, 'Spring');
INSERT INTO tag (id, name) VALUES (3, 'Docker');

-- Inserción de publicaciones (posts)
INSERT INTO post (id, title, content, image_url, created_at, updated_at, author_id, category_id)
VALUES (1, 'Introduction to Spring Boot', 'This is a post about Spring Boot.', 'https://example.com/image1.jpg', NOW(), NOW(), 1, 1);

INSERT INTO post (id, title, content, image_url, created_at, updated_at, author_id, category_id)
VALUES (2, 'Docker Basics', 'Learn Docker from scratch.', 'https://example.com/image2.jpg', NOW(), NOW(), 2, 1);

-- Inserción de relación post-tags (muchos a muchos)
INSERT INTO post_tags (post_id, tags_id) VALUES (1, 1);
INSERT INTO post_tags (post_id, tags_id) VALUES (1, 2);
INSERT INTO post_tags (post_id, tags_id) VALUES (2, 3);

-- Inserción de comentarios
INSERT INTO comment (id, content, created_at, user_id, post_id)
VALUES (1, 'Great post about Spring Boot!', NOW(), 2, 1);

INSERT INTO comment (id, content, created_at, user_id, post_id)
VALUES (2, 'Looking forward to learning Docker.', NOW(), 1, 2);
