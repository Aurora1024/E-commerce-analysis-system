ssh -p 1110 hadoop@10.60.41.125

hive




CREATE TABLE product( product_id string, product string, price double, inventory int, product_sales int, category string, miaomiao string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE;


CREATE TABLE ranking( category_id string, category string, product_id string, product string, category_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';

CREATE TABLE orders( order_id string, product_id string ,order_price double,buyer string,phone string,address string,order_time string)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';


CREATE TABLE category( category_id string, category string, category_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/ly_data/classification.csv' into table category;

CREATE table p_daily(product_id string, day int, d_sales int, d_price double)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/cc_data/p_daily.csv' into table p_daily;
load data local inpath '/home/hadoop/miao4/p_daily.csv' into table p_daily;
CREATE table p_month(product_id string, month int, m_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/cc_data/p_month.csv' into table p_month;
load data local inpath '/home/hadoop/miao3/p_month.csv' into table p_month;

CREATE table p_season(product_id string, season int, s_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/cc_data/p_season.csv' into table p_season;
load data local inpath '/home/hadoop/miao3/p_season.csv' into table p_season;

CREATE table c_season(category_id string, season int, s_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/cc_data/c_season.csv' into table c_season;

CREATE table c_daily(category_id string, day int, d_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/cc_data/c_daily.csv' into table c_daily;

CREATE table c_month(category_id string, month int, m_sales int)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
load data local inpath '/home/hadoop/cc_data/c_month.csv' into table c_month;



insert into ranking (category_id, category, product_id, product, category_sales) values ('51', '进口尖货', '540014180589', 'HoF英国LINEA男士西装长裤全棉商务日常直筒休闲裤2016新款', 114670)
insert into ranking (category_id, category, product_id, product, category_sales) values ('42', '童装会场', '5400143', '国产全棉亲子日常儿童纸尿裤2017新款小阳阳代言版', 514670)
insert into ranking (category_id, category, product_id, product, category_sales) values ('42', '童装会场', '5400144', '进口版高级高达外套 原价【200】现价【103】', 324670)
insert into ranking (category_id, category, product_id, product, category_sales) values ('42', '童装会场', '54014251', '可爱卡通风Hive版长袖', 1246132)
insert into ranking (category_id, category, product_id, product, category_sales) values ('42', '童装会场', '14014251', '韩风宝宝儿童纸尿裤', 2463122)
insert into ranking (category_id, category, product_id, product, category_sales) values ('42', '童装会场', '14014251', '源源可爱画风洋娃娃', 5189721)

