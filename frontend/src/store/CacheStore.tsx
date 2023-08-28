interface CacheItem {
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  data: any;
}

export class ApiCache<T> {
  private cache: Record<string, CacheItem> = {};

  get(url: string): T | null {
    const cacheItem = this.cache[url];
    if (cacheItem) {
      return cacheItem.data;
    }
    return null;
  }

  set(url: string, data: T): void {
    this.cache[url] = {
      data,
    };
  }
}
