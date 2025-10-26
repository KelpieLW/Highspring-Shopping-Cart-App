-- ===== Categories =====

INSERT INTO category (name, description, discountrate)
VALUES ('Computer Parts', 'Disk drives, Processors, GPU''s and all the necessary parts to build your own computer', 0.05);

INSERT INTO category (name, description, discountrate)
VALUES ('Accessories', 'All the accesories you need for your gaming or office environment!', 0.1);

INSERT INTO category (name, description, discountrate)
VALUES ('Built Computers', 'We already built the computer for you, look in your big catalogue of prebuilt computers for every need', 0.15);

INSERT INTO category (name, description, discountrate)
VALUES ('Laptops', 'Take the gaming or office work anywhere in the world', 0.0);

INSERT INTO category (name, description, discountrate)
VALUES ('Monitors', 'Monitors of all shapes and sizes for your computer', 0.3);

-- ===== Items =====
-- ===== Items - Computer parts=====

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES ('AMD-RYZEN 5 7600', 'AMD-RYZEN-5-7600 Processor', 230.20, 1, '/itemPictures/computer-parts/AMD-RYZEN-5-7600.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES ('Crucial m2-1TB-P3-Plus','Crucial-m2-1TB-P3-Plus M2 disk drive for storage',25.0,1,'/itemPictures/computer-parts/Crucial-m2-1TB-P3-Plus.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES ('Power Supply ICEBERG-500W','Power Supply with 500w capacity', 39.55, 1,'/itemPictures/computer-parts/PS-ICEBERG-500W.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES ('GeForce® GTX-1650-D6-OC-4G','Nvidia GPU for gaming', 199.99, 1,'/itemPictures/computer-parts/GeForce®-GTX-1650-D6-OC-4G.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES ('GeForce RTX™-5060-Ti', 'Nvidia GPU for gaming',299.50,1,'/itemPictures/computer-parts/ssAAQGeForce-RTX™-5060-Ti.png');

-- ===== Items - Accessories=====

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES ('LOGITECH BRIO 4K-PRO WEBCAM', 'Web camera with high definition', 35.00,2,'/itemPictures/accessories/LOGITECH-BRIO-4K-PRO-WEBCAM.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('G733 Blue 1','Logitech Headphones', 54.99,2,'/itemPictures/accessories/G733-BLUE-1.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('Logitech G335 Black','Black Logitech Headphones', 52.99,2,'/itemPictures/accessories/Logitech-G335.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('Havit Keyboard KB901L 1','Havit mechanical Keyboard',85.50,2,'/itemPictures/accessories/HAVIT-KB901L-1.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('MCJR-009 Microphone', 'High Definition Microphone',75.00,2,'/itemPictures/accessories/MCJR-009.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('Mouse-HAVIT-MS979WB-2','Gamer Mouse Havit',65.99,2,'/itemPictures/accessories/MouseHAVIT-MS979WB-2.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('PATRIOT SUPERSONIC LITE 64GB USB','Storage USB', 14.99,2,'/itemPictures/accessories/PATRIOT-SUPERSONIC-LITE-64GB-1.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('Magnus Keyboard','Magnus mechanical keyboard',72.00,2,'/itemPictures/accessories/tclXK-63-MAGNUS-1.png');

-- ===== Items - Built Computers=====


INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('AMD RYZEN 7 5700X Desktop Computer','Computer built with AMD Ryzen 7 CPU',700.00 ,3,'/itemPictures/built-computers/AMD RYZEN 7 5700X.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('AMD RYZEN-5 5600X Desktop Computer', 'Copmuter built with AMD Ryzen 5 CPU', 590.50,3,'/itemPictures/built-computers/ATX-L46-AMD-RYZEN-5-5600X-BOARD-MSI.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('ASUS-PRIME-B550M Desktop Computer','Computer built on ASUS-Prime-B550M Board',450.00,3,'/itemPictures/built-computers/ATX-Lander-500-BOARD-ASUS-PRIME-B550M.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('RYZEN-5-8600G8600g-clx18 Desktop Computer', 'Computer built with Ryzen 5 8600G CPU',420.99, 3,'/itemPictures/built-computers/RYZEN-5-8600G8600g-clx18.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('RYZEN-7-8700-F Desktop Computer','Computer built with a Ryzen-7-8700 CPU',769.99,3,'/itemPictures/built-computers/RYZEN-7-8700-F-LANDERPC-RYZEN-7-8-2.png');

-- ===== Items - Laptops=====

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('ASUS 1504FA Laptop','Laptop adapted for office work',390.00,4,'/itemPictures/laptops/ASUS 1504FA.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('ASUS-E1504GA INTEL CORE-I3 Laptop','Laptop adapted for video rendering',420.00,4,'/itemPictures/laptops/ASUS-E1504GA-NJ697-INTEL-CORE-I3-N305-8GB-DDR4-512-SSD-156-FHD-1-FREEDOS-Indie-Black-2.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('LENOVO SLIM 3 15IRH8 Laptop','Light Laptop for easy traveling',299.99,4,'/itemPictures/laptops/LENOVO SLIM 3 15IRH8.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('MSI MODERN 13 F13MG Laptop','Laptop adapted for gaming',499.99,4,'/itemPictures/laptops/MSI MODERN 13 F13MG.png');

-- ===== Items - Monitors=====

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('AOC-24-24B2XH-1 Monitor','HD 24 Inch Monitor',89.00,5,'/itemPictures/monitors/AOC-24-24B2XH-1.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('Havit-acer-27 Monitor','HD gaming 27 Inch monitor',100.00,5,'/itemPictures/monitors/havit-acer-27-.png');

INSERT INTO item (name, description, price, category_Id, itemImageUrl)
VALUES('Dahua-Gamer-DHI Monitor','2k High Refresh rate Gamer monitor',110.99,5,'/itemPictures/monitors/Monitor-Dahua-Gamer-DHI-LM24-E230C-24-Negro-1.png');