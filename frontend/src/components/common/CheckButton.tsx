import React from 'react';

export interface checkButtonOption {
  selected?: boolean;
}

function checkIconStatus(selected: boolean | undefined) {
  return selected ? (
    <img src="/images/blue-lg-check-icon.svg" width={24} height={24} />
  ) : (
    <img src="/images/grey-lg-check-icon.svg" width={24} height={24} />
  );
}

function CheckButton(props: checkButtonOption) {
  return checkIconStatus(props.selected);
}

export default CheckButton;
