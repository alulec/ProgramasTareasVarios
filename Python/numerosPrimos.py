x = 1000
while (x != 1):
  n = 2
  while(n<=x):
    if (n == x):
      print(x, end=", ")
      n = x + 2
    if((x%n)!=0):
      n = n + 1
    else:
      n = x + 2
  x = x - 1
