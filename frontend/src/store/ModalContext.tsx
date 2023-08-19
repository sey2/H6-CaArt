import React, { createContext, useContext, useReducer, Dispatch } from 'react';
import { OptionType } from '../pages/vehicleEstimationPage/TrimEstimationPage';

type Action =
  | { type: 'OPEN_INFO_MODAL' }
  | { type: 'CLOSE_INFO_MODAL' }
  | { type: 'OPEN_COMPARE_MODAL' }
  | { type: 'CLOSE_COMPARE_MODAL' }
  | { type: 'OPEN_TOOLTIP_MODAL' }
  | { type: 'CLOSE_TOOLTIP_MODAL' }
  | { type: 'SET_TOOLTIP_TYPE'; tooltipType: string }
  | { type: 'SET_TOOLTIP_POSITION'; position: { x: number; y: number } }
  | { type: 'OPEN_OPTION_MODAL' }
  | { type: 'CLOSE_OPTION_MODAL' }
  | { type: 'SET_OPTION_POSITION'; position: { x: number; y: number } }
  | { type: 'SET_OPTION_DATA'; data: OptionType }
  | { type: 'OPEN_RECOMMEND_MODAL' }
  | { type: 'CLOSE_RECOMMEND_MODAL' };

interface TrimModalState {
  infoModalOpen: boolean;
  compareModalOpen: boolean;
  tooltipOpen: boolean;
  tooltipType: string | undefined;
  tooltipPosition: { x: number; y: number };
  optionModalOpen: boolean;
  optionModalPosition: { x: number; y: number };
  optionModalData: OptionType;
  recommendModalOpen: boolean;
}

const initialState: TrimModalState = {
  infoModalOpen: false,
  compareModalOpen: false,
  tooltipOpen: false,
  tooltipType: '엔진',
  tooltipPosition: { x: 0, y: 0 },
  optionModalOpen: false,
  optionModalPosition: { x: 0, y: 0 },
  optionModalData: {
    optionId: 0,
    optionName: '',
    description: '',
    optionImage: '',
  },
  recommendModalOpen: false,
};

function reducer(state: TrimModalState, action: Action): TrimModalState {
  switch (action.type) {
    case 'OPEN_INFO_MODAL':
      return { ...state, infoModalOpen: true };
    case 'CLOSE_INFO_MODAL':
      return { ...state, infoModalOpen: false };
    case 'OPEN_COMPARE_MODAL':
      return { ...state, compareModalOpen: true };
    case 'CLOSE_COMPARE_MODAL':
      return { ...state, compareModalOpen: false };
    case 'OPEN_TOOLTIP_MODAL':
      return { ...state, tooltipOpen: true };
    case 'CLOSE_TOOLTIP_MODAL':
      return { ...state, tooltipOpen: false };
    case 'SET_TOOLTIP_TYPE':
      return { ...state, tooltipType: action.tooltipType };
    case 'SET_TOOLTIP_POSITION':
      return { ...state, tooltipPosition: action.position };
    case 'OPEN_OPTION_MODAL':
      return { ...state, optionModalOpen: true };
    case 'CLOSE_OPTION_MODAL':
      return { ...state, optionModalOpen: false };
    case 'SET_OPTION_POSITION':
      return { ...state, optionModalPosition: action.position };
    case 'SET_OPTION_DATA':
      return { ...state, optionModalData: action.data };
    case 'OPEN_RECOMMEND_MODAL':
      return { ...state, recommendModalOpen: true };
    case 'CLOSE_RECOMMEND_MODAL':
      return { ...state, recommendModalOpen: false };
    default:
      return state;
  }
}

type DispatchType = Dispatch<Action>;

const ModalStateContext = createContext<TrimModalState | undefined>(undefined);
const ModalDispatchContext = createContext<DispatchType | undefined>(undefined);

export function ModalProvider({ children }: { children: React.ReactNode }) {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <ModalStateContext.Provider value={state}>
      <ModalDispatchContext.Provider value={dispatch}>
        {children}
      </ModalDispatchContext.Provider>
    </ModalStateContext.Provider>
  );
}

export function useModalContext() {
  const state = useContext(ModalStateContext);
  const dispatch = useContext(ModalDispatchContext);

  if (state === undefined || dispatch === undefined) {
    throw new Error('useModalContext must be used within a ModalProvider');
  }

  return { state, dispatch };
}
