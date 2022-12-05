  const sortArray = (array, type) => {
    type === 'crescent' ? array?.sort((a, b) => a - b) : array?.sort((a, b) => b - a);
    return array;
  };
  const addLeadingZeros = (num, totalLength) => {
    return String(num).padStart(totalLength, '0');
  };
  const convert_to_cpf = (number) => {
    const numbers = number?.match(/\d/g)?.join('');
    const eleven_numbers = addLeadingZeros(numbers, 11);
    return cpfMask(eleven_numbers);
  };
  const cpfMask = (cpf) =>{
    cpf=cpf.replace(/\D/g,'');
    cpf=cpf.replace(/(\d{3})(\d)/,'$1.$2');
    cpf=cpf.replace(/(\d{3})(\d)/,'$1.$2');
    cpf=cpf.replace(/(\d{3})(\d{1,2})$/,'$1-$2');
    return cpf;
  };
  const currencyFormat = (value) => {
    let formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
    });
    return formatter.format(value);
  };

  export {currencyFormat, cpfMask, addLeadingZeros, convert_to_cpf, sortArray};