# Time to shape text with different calt code

Baseline:

```
sub 1 2 3 4 by 1_2_3_4.liga;
```

Spacers:

```
sub 1.spacer 2.spacer 3.spacer 4' by 1_2_3_4.liga;
sub 1.spacer 2.spacer 3'       4  by 3.spacer;
sub 1.spacer 2'       3        4  by 2.spacer;
sub 1'       2        3        4  by 1.spacer;
```

Lookups:

```
lookup 1_2_3_4 {
  sub 1.spacer 2.spacer 3.spacer 4' by 1_2_3_4.liga;
  sub 1.spacer 2.spacer 3'       4  by 3.spacer;
  sub 1.spacer 2'       3        4  by 2.spacer;
  sub 1'       2        3        4  by 1.spacer;
} 1_2_3_4;
```

Ignores:

```
lookup 1_2_3_4 {
  ignore sub 1 1' 2 3 4;
  ignore sub 1' 2 3 4 4;
  sub 1.spacer 2.spacer 3.spacer 4' by 1_2_3_4.liga;
  sub 1.spacer 2.spacer 3'       4  by 3.spacer;
  sub 1.spacer 2'       3        4  by 2.spacer;
  sub 1'       2        3        4  by 1.spacer;
} 1_2_3_4;
```

Benchmark:

```
time hb-shape -n 100000 distr/ttf/FiraCode-Regular.ttf "Hello +++ /// !== <-> world"
```

Setup:

```
HarfBuzz 2.6.4
3,2 GHz 6-Core Intel Core i7
MacOS 10.15.3
```

Results:

```
Baseline 0.407s
Spacers  1.415s
Lookups  2.080s
Ignores  2.656s
```