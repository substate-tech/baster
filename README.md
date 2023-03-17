<!--- 
This is the README.md for Baster - a Basic Unit Tester extending ChiselTest 
--->
A very simple extension of [ChiselTest](https://github.com/ucb-bar/chiseltest)

# Overview
Baster extends ChiselTest with a few items I've found really useful when creating unit tests:

1. Support for randomization and controlling the randomization seed on the SBT command line
2. Command line support for a debug flag that can be passed into DUT for extra messages
3. Command line support for a verbose flag that can be passed into DUT or tests for verbose messages
4. Command line support to change the default backend from Treadle to, e.g. Verilator

# Usage
Baster just creates a `BaseUnitTester` trait as follows:

```scala
trait BaseUnitTester extends AnyFlatSpec
    with ChiselScalatestTester
    with BeforeAndAfterAllConfigMap {...
```

To use baster, just create your own UnitTester class as follows:
```scala
abstract class MyUnitTester extends BaseUnitTester {...
```
Then write your tests as you would with ChiselTest. However, now that you're using baster you'll have command line access to all the features described in the overview above. The features are controlled on the SBT command line in the same way as VCD waveform dump is controlled in ChiselTest e.g.:

`test -- -DwriteVcd=1`

The new options you get with baster are:
- `-Dbackend=verilator` : select Verilator as the simulator instead of Treadle (the default). When Verilator is selected line-coverage is also enabled
- `-Dseed=123` : specify 123 as the randomization seed (the specified seed is used to initialize the built-in `rand` variable)
- `-Ddebug=1` : pass the DEBUG flag into the unit tester (this lets you control the level of debug visibility in your tests via the built-in `_debug` variable)
- `-Dverbose=1` : pass the VERBOSE flag into the unit tester (this lets you control the level of verbosity of messages in your tests via the built-in `_verbose` variable)

That's it!
