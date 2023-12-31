all: build

build:
	docker run --rm -v ${PWD}:/opt tonsky/firacode:latest ./script/build.sh

package:
	./script/package.sh
