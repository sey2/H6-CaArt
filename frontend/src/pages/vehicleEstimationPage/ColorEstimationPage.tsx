import React, { useState } from 'react';
import Dropdown from '../../components/vehicleEstimationPage/colorEstimationPage/Dropdown';
import ColorChangePopup from "../../components/vehicleEstimationPage/colorEstimationPage/ColorChangePopup";
    
function ColorEstimationPage() {
  const [innerDDState, setInnerDDState] = useState(false);
  const [outerDDState, setOuterDDState] = useState(false);
  const [modal, setModal] = useState(false);
  
  return (
    <>
     <span onClick={()=>setModal(true)}>열기</span>
     {modal && <ColorChangePopup setter={setModal} />}
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
