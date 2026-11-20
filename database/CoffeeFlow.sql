-- CoffeeFlow | Etapa 4
-- Execute este arquivo no MySQL Workbench para criar o banco e os dados iniciais.
CREATE DATABASE IF NOT EXISTS CoffeeFlow CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE CoffeeFlow;

CREATE TABLE IF NOT EXISTS funcionarios (
  id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cargo VARCHAR(50) NOT NULL,
  nivel_acesso INT NOT NULL DEFAULT 1
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS produtos (
  id_produto INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  preco_unitario DECIMAL(10,2) NOT NULL,
  CONSTRAINT chk_produto_preco CHECK (preco_unitario > 0)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS insumos (
  id_insumo INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  quantidade_estoque INT NOT NULL DEFAULT 0,
  CONSTRAINT chk_insumo_estoque CHECK (quantidade_estoque >= 0)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS receita (
  id_produto INT NOT NULL,
  id_insumo INT NOT NULL,
  quantidade_utilizada INT NOT NULL,
  PRIMARY KEY (id_produto,id_insumo),
  CONSTRAINT fk_receita_produto FOREIGN KEY (id_produto) REFERENCES produtos(id_produto),
  CONSTRAINT fk_receita_insumo FOREIGN KEY (id_insumo) REFERENCES insumos(id_insumo),
  CONSTRAINT chk_receita_quantidade CHECK (quantidade_utilizada > 0)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS pedidos (
  id_pedido INT AUTO_INCREMENT PRIMARY KEY,
  data_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_funcionario INT NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  CONSTRAINT fk_pedido_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id_funcionario),
  CONSTRAINT chk_pedido_total CHECK (valor_total >= 0),
  INDEX idx_pedidos_data (data_pedido)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS itens_pedidos (
  id_itens INT AUTO_INCREMENT PRIMARY KEY,
  id_pedido INT NOT NULL,
  id_produto INT NOT NULL,
  quantidade INT NOT NULL,
  subtotal DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_item_pedido FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
  CONSTRAINT fk_item_produto FOREIGN KEY (id_produto) REFERENCES produtos(id_produto),
  CONSTRAINT chk_item_quantidade CHECK (quantidade > 0),
  CONSTRAINT chk_item_subtotal CHECK (subtotal >= 0),
  INDEX idx_itens_pedido (id_pedido)
) ENGINE=InnoDB;

-- Dados iniciais: inserção condicional para evitar duplicação ao executar novamente.
INSERT INTO funcionarios (nome,cargo,nivel_acesso)
SELECT 'Ana Costa','Barista',2 WHERE NOT EXISTS (SELECT 1 FROM funcionarios WHERE nome='Ana Costa');
INSERT INTO funcionarios (nome,cargo,nivel_acesso)
SELECT 'Lucas Mendes','Atendente',2 WHERE NOT EXISTS (SELECT 1 FROM funcionarios WHERE nome='Lucas Mendes');
INSERT INTO funcionarios (nome,cargo,nivel_acesso)
SELECT 'Maria Oliveira','Gerente',1 WHERE NOT EXISTS (SELECT 1 FROM funcionarios WHERE nome='Maria Oliveira');

INSERT INTO produtos (nome,preco_unitario)
SELECT 'Espresso',5.00 WHERE NOT EXISTS (SELECT 1 FROM produtos WHERE nome='Espresso');
INSERT INTO produtos (nome,preco_unitario)
SELECT 'Cappuccino',12.50 WHERE NOT EXISTS (SELECT 1 FROM produtos WHERE nome='Cappuccino');
INSERT INTO produtos (nome,preco_unitario)
SELECT 'Latte',11.00 WHERE NOT EXISTS (SELECT 1 FROM produtos WHERE nome='Latte');
INSERT INTO produtos (nome,preco_unitario)
SELECT 'Pão de queijo',7.00 WHERE NOT EXISTS (SELECT 1 FROM produtos WHERE nome='Pão de queijo');

INSERT INTO insumos (nome,quantidade_estoque)
SELECT 'Grãos de café',5000 WHERE NOT EXISTS (SELECT 1 FROM insumos WHERE nome='Grãos de café');
INSERT INTO insumos (nome,quantidade_estoque)
SELECT 'Leite integral',80 WHERE NOT EXISTS (SELECT 1 FROM insumos WHERE nome='Leite integral');
INSERT INTO insumos (nome,quantidade_estoque)
SELECT 'Chocolate em pó',1000 WHERE NOT EXISTS (SELECT 1 FROM insumos WHERE nome='Chocolate em pó');
INSERT INTO insumos (nome,quantidade_estoque)
SELECT 'Açúcar',2000 WHERE NOT EXISTS (SELECT 1 FROM insumos WHERE nome='Açúcar');

INSERT INTO receita (id_produto,id_insumo,quantidade_utilizada)
SELECT p.id_produto,i.id_insumo,15 FROM produtos p JOIN insumos i ON i.nome='Grãos de café'
WHERE p.nome='Espresso' AND NOT EXISTS (SELECT 1 FROM receita r WHERE r.id_produto=p.id_produto AND r.id_insumo=i.id_insumo);
INSERT INTO receita (id_produto,id_insumo,quantidade_utilizada)
SELECT p.id_produto,i.id_insumo,15 FROM produtos p JOIN insumos i ON i.nome='Grãos de café'
WHERE p.nome='Cappuccino' AND NOT EXISTS (SELECT 1 FROM receita r WHERE r.id_produto=p.id_produto AND r.id_insumo=i.id_insumo);
INSERT INTO receita (id_produto,id_insumo,quantidade_utilizada)
SELECT p.id_produto,i.id_insumo,150 FROM produtos p JOIN insumos i ON i.nome='Leite integral'
WHERE p.nome='Cappuccino' AND NOT EXISTS (SELECT 1 FROM receita r WHERE r.id_produto=p.id_produto AND r.id_insumo=i.id_insumo);

-- Consultas rápidas para conferir a carga inicial.
SELECT * FROM funcionarios ORDER BY id_funcionario;
SELECT * FROM produtos ORDER BY id_produto;
SELECT * FROM insumos ORDER BY id_insumo;
SELECT p.id_pedido,p.data_pedido,f.nome AS funcionario,p.valor_total
FROM pedidos p JOIN funcionarios f ON f.id_funcionario=p.id_funcionario
ORDER BY p.id_pedido DESC;
