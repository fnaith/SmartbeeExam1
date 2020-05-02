import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function CompanyInfoAddress(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.companyInfos[index].address = input;
  };

  return (
    <TextField id={'company-form-address-' + index} label="Address"
      defaultValue={global_data.companyInfos[index].address} margin="dense" onChange={onChange}/>
  );
}

export default CompanyInfoAddress;
