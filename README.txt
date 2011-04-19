Installing Hardware inventory:

- Install eclipse http://www.eclipse.org/downloads/

- Clone the git repo:
git clone git@github.com:ressia/HardwareInventory.git


- Install MySQL
http://mysql.com/why-mysql/white-papers/mysql_wp_high-availability_webrefarchs.php
	- cd to the directory where mysql is
	- cd scripts
	- exe ./mysql_install_db --basedir ../bin/

- setting up the eclipse environment:
	- create a new java project
	- unselect default location and choose the folder where HardwareInventory repo is.
	- add the src, test, resources folder to the project.


- Execute the main in the class hwinventory.InventoryMain for testing the database connection.
If you require to change your data base configuration check the file hibernate.cfg.xml in resources.

- download and install apache tomcat from http://tomcat.apache.org/

- for building the war run:
	mvn package
	copy the war to APACHE_HOME/webapps
	restart tomcat
	
	
