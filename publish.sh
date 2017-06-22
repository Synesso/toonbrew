#!/bin/bash -x

tar czvf pack.tgz img/ css index.html target/scala-2.12/*.js
git stash
git checkout site
for f in `find`; do git rm -rf $f; done
tar zxvf pack.tgz
for f in `tar tf pack.tgz`; do git add $f; done
