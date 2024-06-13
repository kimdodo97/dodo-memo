CREATE TABLE POST (
                      post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      content VARCHAR(255) NOT NULL,
                    create_at DATE NOT NULL
);
