Abiquo compatible Hypervisor mock
=================================

It pretends to be an Hypervisor, but its simply a mock.


# How to

Clone the repo, pack it and play with it!

~~~
$ mvn clean package

$ java -jar target/vbox-mock.jar [path_to_configuration_file]

~~~

The hypervisor mock accepts an optional parameter which is the path to the configuration file to load. If no file is provided the default file is loaded.

You can set your own configuration file or modify one of the few [example configuration files](http://github.com/abiquo/hypervisor-mock/src/main/resources/examples) that the mock provides.

## Configuration files

To create or modify a configuration file is pretty straightforward. Best thing you can do is copy and modify the [default configuration file]((http://github.com/abiquo/hypervisor-mock/src/main/resources/conf/vbox.yaml).

The most noteworthy paramteres are:

* vbox_port. Default value 18083
* aim_port. Default value 8889

Which are the ports where the processes will be listening for incoming connections.


# Components

## Hypervisor mock

There are different handlers to implement delay and failures. All of them can be put together if the performance becomes a problem. Now the deserialization is taking up to 2ms (in a development machine). So I rather gain in code maintainability than performance.

## AIM java server mock

The thrift based java server mock to use Abiquo AIM http://github.com/abiquo/aim

* References
** [Thrift Java Servers Compared](https://github.com/m1ch1/mapkeeper/wiki/Thrift-Java-Servers-Compared)

## Common issues

* Permgen or memory size: Try adding more memory to the startup command `java -Xmx128m -jar vbox-mock.jar`
* NullPointerException when shutting down web service: This is due to a known issue in JAX-WS 2.1.x and JDK 6. Try executing it with another JDK or add JAX-WS 2.2 to your endorsed libs or disabling the Web Service shutdown by setting the property hypervisor_disconnect_ratio to 0 in your configuration file.
