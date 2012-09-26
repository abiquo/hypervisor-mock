Abiquo compatible Hypervisor mock
=================================

It pretends to be an Hypervisor, but its simply a mock.


# Components

## Hypervisor mock

There are different handlers to implement delay and failures. All of them can be put together if the performance becomes a problem. Now the deserialization is taking up to 2ms (in a development machine). So I rather gain in code maintainability than performance.

## AIM java server mock

The thrift based java server mock to use Abiquo AIM http://github.com/abiquo/aim

* References
** [Thrift Java Servers Compared](https://github.com/m1ch1/mapkeeper/wiki/Thrift-Java-Servers-Compared)
