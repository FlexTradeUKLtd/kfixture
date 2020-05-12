if [[ ${TRAVIS_PULL_REQUEST} = 'false' ]];
then
    gpg --version
	  gpg --import flexUK-private-key.gpg
    mvn clean deploy -P sign-artifacts --settings ./settings.xml;
else
    mvn clean verify;
fi
