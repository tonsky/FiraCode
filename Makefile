all: build

build:
	docker run --rm -v ${PWD}:/opt tonsky/firacode:latest ./script/build.sh -w Retina

package:
	./script/package.sh
