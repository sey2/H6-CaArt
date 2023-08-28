function replaceWonSymbol(str: string) {
  const retStr = str.replace(/\\n/gi, '\n');
  return retStr;
}

export default replaceWonSymbol;
