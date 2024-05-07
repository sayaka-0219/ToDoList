DROP TABLE IF EXISTS todolist;
 CREATE TABLE todolist (
  id int unsigned AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  status BOOLEAN,
  PRIMARY KEY(id)
 );
INSERT INTO todolist (title, description, status) VALUES ("要件定義", "クラス名やアーキテクチャを定義", true);
INSERT INTO todolist (title, description, status) VALUES ("DBの作成", "テーブル内容を定義", true);
INSERT INTO todolist (title, description, status) VALUES ("プロジェクトを作成", "CURD処理を実装", true);
INSERT INTO todolist (title, description, status) VALUES ("テスト", "テストを実行", true);
INSERT INTO todolist (title, description, status) VALUES ("画面の作成", "HTML、Javascriptを使って画面を作成", false);
INSERT INTO todolist (title, description, status) VALUES ("テスト", "テストを実行", false);