import React, { useState } from 'react';
import Dropdown from '../../components/vehicleEstimationPage/colorEstimationPage/Dropdown';

function ColorEstimationPage() {
  const [innerDDState, setInnerDDState] = useState(false);
  const [outerDDState, setOuterDDState] = useState(false);

  return (
    <>
    <Dropdown
      type="inner"
      innerColorDDState={innerDDState}
      innerColorDDSetter={setInnerDDState}
      outerColorDDState={outerDDState}
      outerColorDDSetter={setOuterDDState}
    />
    <Dropdown
    type="outer"
    innerColorDDState={innerDDState}
    innerColorDDSetter={setInnerDDState}
    outerColorDDState={outerDDState}
    outerColorDDSetter={setOuterDDState}
  />
</>
  );
}

export default ColorEstimationPage;
