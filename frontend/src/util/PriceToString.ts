function priceToString(price: number): string {
  const formatter = new Intl.NumberFormat('ko-KR', {
    style: 'currency',
    currency: 'KRW',
    minimumFractionDigits: 0,
  });

  return `${formatter.format(price).slice(1)}원`;
}

export { priceToString };
