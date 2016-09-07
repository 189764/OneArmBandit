# OneArmBandit

OneArmBandit is a client-server desktop application, which actually consists of two applications: <br>
1) server run on central machine <br>
2) client run on client machine, which allows player and admin to play and change parameters of game<br>
All logical operation are done on server. Client is used to collect data from user and send them to the server via socket. 
In order to communicate client and server we send object. 	


## Installation

In order to bulid the project you have to:<br>
1. Clone project using git<br>
2. Import your project in Eclipse and then use maven or use maven in your console<br>
3. Compile project using maven [clean install compile]<br>
4. At first you have to run "main" in server package (if required change port and ip address in "config.properties" file)<br> 
5. Then you can run "main" in client package<br>

## Usage

When you run client application you can log in or register.<br>
Depends on what account you log on you see different windows.<br>
When you choose admin account (default account login: admin; password: admin):<br>
You can transfer transfer bank from central bank to bandit machine and set prizes for particular symbols on bandit machine.<br>
You can also of course log out.<br>
If you log in or register on player account you have 5 option: play, see your account, see ranking, change password and log out.<br>
When you want to play click "play" button and set your stake. Then you can see which symbols you draw and there will be displayed your prize<br>

## Contributing

1. Create your feature branch: `git checkout -b my-new-feature`
2. Commit your changes: `git commit -a -m 'Add some feature'`
3. Push to the branch: `git push origin my-new-feature`
4. Submit a pull request 


## Credits

Rafal Rygas 189764<br>
Sebastian Swiątek 189790<br>
Karolina Kmiecik 189688<br>
Magdalena Kowalska 189699<br>
