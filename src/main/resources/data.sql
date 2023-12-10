INSERT INTO post (id,       title,            description,             content,        created_at,        updated_at)
VALUES           (1,       'Java Advanced',   'JPA',                   'BlogApp',      CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                 (2,       'HTML',            'HTML - CSS',             'BlogApp',     CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                 (3,       'MySQL',           'MySQL - Workbeen',      'BlogApp',      CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                 (4,       'NodeJs',          'NodeJs',                 'BlogApp',     CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comment (id,   name,                 email,                  body,               created_at,          updated_at,         post_id)
VALUES              (1,   'Nguyễn Văn Bộ',      'bonv@gmail.com',      'Đang học Spring',    CURRENT_TIMESTAMP,   CURRENT_TIMESTAMP,  1      ),
                    (2,   'Nguyễn Văn Nam',     'namnv@gmail.com',      'Đang học Spring',   CURRENT_TIMESTAMP,   CURRENT_TIMESTAMP,  1      ),
                    (3,   'Nguyễn Văn Cường',   'cuongnv@gmail.com',    'Đang học Spring',   CURRENT_TIMESTAMP,   CURRENT_TIMESTAMP,  2      ),
                    (4,   'Nguyễn Văn Mạnh',    'manhnv@gmail.com',     'Đang học Spring',   CURRENT_TIMESTAMP,   CURRENT_TIMESTAMP,  3      ),
                    (5,   'Nguyễn Văn Dũng',    'dungnv@gmail.com',     'Đang học Spring',   CURRENT_TIMESTAMP,   CURRENT_TIMESTAMP,  3      ),
                    (6,   'Nguyễn Văn Trường',  'truongnv@gmail.com',   'Đang học Spring',   CURRENT_TIMESTAMP,   CURRENT_TIMESTAMP,  2      );