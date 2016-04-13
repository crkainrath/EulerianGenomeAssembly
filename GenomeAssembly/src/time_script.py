#!/usr/bin/env python
import os
seq_lens=[10, 50, 100, 250, 500, 1000, 2500, 5000, 10000, 20000, 50000, 100000, 500000, 1000000]
min_lmer = 3
max_lmer = 20
for i in seq_lens:
	command_to_exec = "java TimeTest %d %d %d >> time_data.txt" % (i, min_lmer, max_lmer)
	os.system(command_to_exec)

