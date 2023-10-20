{ pkgs ? import ./nix }:

pkgs.mkShell {
  buildInputs = with pkgs; [ npins jdk17 gradle jdt-language-server ];
}
