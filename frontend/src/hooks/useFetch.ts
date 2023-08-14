import { useState, useEffect } from 'react';

type FetchStatus = 'idle' | 'loading' | 'success' | 'error';

interface FetchResponse<T> {
  data: T | null;
  error: string | null;
  status: FetchStatus;
}

const BASE_URL = 'https://api.ca-art.store';

const useFetch = <T>(url: string): FetchResponse<T> => {
  const [data, setData] = useState<T | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [status, setStatus] = useState<FetchStatus>('idle');

  useEffect(() => {
    if (!url) return;

    const fetchData = async () => {
      setStatus('loading');
      try {
        const response = await fetch(`${BASE_URL}${url}`);
        if (!response.ok) {
          throw new Error(`${response.status}: ${response.statusText}`);
        }
        const jsonData = await response.json();
        setData(jsonData.data);
        setStatus('success');
      } catch (error) {
        setError(String(error));
        setStatus('error');
      }
    };

    fetchData();
  }, [url]);

  return { data, status, error };
};

export { useFetch };
