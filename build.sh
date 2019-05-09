if [[ ${TRAVIS_PULL_REQUEST} = 'false' ]];
then
	echo $CI_DEPLOY_USERNAME
    mvn deploy --settings ./settings.xml;
else
    mvn clean verify;
fi
