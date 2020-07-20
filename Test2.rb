STDOUT.sync = true
_,w,_,e,o,_,_,n=gets.split.map(&:to_i)
l={}
n.times{f,x=gets.split.map(&:to_i);l[f]=x}
# I have to check to see if the clone floor has elevator  or not and 
# I also fix the condition when we print out the result. I compare c (position of the leading clone on its floor) to x (the position of the current exit and its direction)
loop{f,c,d=gets.split;f,c=f.to_i,c.to_i;x= f==e ? o : ((l[f].nil?) ? 0 : l[f]);puts (c>x && d == "RIGHT" || c < x && d == "LEFT") ? "BLOCK" : "WAIT"}