line=$(git status | grep deleted | awk 'END {print NR} ')

for((i=1;i<=line;i++))
{
	string=$(git status | grep deleted | awk -v countLine=$i  'NR==countLine {print $2} ')
#	echo $string
	command=$(echo git rm $string)
#	echo $command
	eval $command
}

